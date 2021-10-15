package com.example.tankhah.core.Faktor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import com.example.tankhah.core.getdata
import ir.duck.hooshro.setting.SharePref

class adapterfaktor(private val context:Context, private var fak: List<ItemFaktorModel>, sharePref: SharePref , callback : getdata) : RecyclerView.Adapter<adapterfaktor.viewfinder>() {


    private var sharePref = sharePref
    private var get =  callback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewfinder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_recycleview_faktor, parent, false)
        return viewfinder(view)
    }


    override fun onBindViewHolder(holder: viewfinder, position: Int) {
        var sd = 0
        holder.apply {
            txtissue.text = fak.get(position).isuue.toString()
            txtxplan.text = fak.get(position).xplan
            txtmony.text = fak.get(position).mony
            sd = fak.get(position).monyall
            var finsh =" $sd ریال "
            txtmonyall.text = finsh
            txtnumber.text = fak.get(position).number
        }

        get.getposition(position)
    }

    override fun getItemCount(): Int = fak.size

//
//    fun sumitlist(fakk:List<itemfaktormodel>){
//        val oldlist = fak
//        val diffResult:DiffUtil.DiffResult = DiffUtil.calculateDiff(
//            BlogItemDiffVallBack(
//                  oldlist,
//                fakk
//            )
//        )
//        fak = fakk
//        diffResult.dispatchUpdatesTo(this)
//    }

//    class BlogItemDiffVallBack(var oldfak: List<itemfaktormodel>,var  newfak:List<itemfaktormodel>)
//        :DiffUtil.Callback(){
//        override fun getOldListSize(): Int {
//            return oldfak.size
//        }
//
//        override fun getNewListSize(): Int {
//            return newfak.size
//        }
//
//        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            return (oldfak.get(oldItemPosition).isuue == newfak.get(newItemPosition).isuue)
//        }
//
//        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//            return oldfak.get(oldItemPosition).equals(newfak.get(newItemPosition))
//        }
//
//    }


//    fun add(itemfaktormodel: itemfaktormodel?) {
//        fak.add(itemfaktormodel)
//        notifyDataSetChanged()
//    }
//
//    fun add(item: List<itemFaktorModel>) {
//        this.fak = item
//        notifyDataSetChanged()
//    }
//
//    fun set(pern: List<itemFaktorModel?>) {
//        this.fak = pern as List<itemFaktorModel>
//        notifyDataSetChanged()
//    }
//
//
//    fun delete(itemFaktorModel: itemFaktorModel) {
//        for (i in fak.indices) {
//            if (fak.get(i).isuue === itemFaktorModel.isuue ) {
////                fak = (i)
//                notifyItemRemoved(i)
//                break
//            }
//        }
//    }
//
//    fun update(itemFaktorModel: itemFaktorModel) {
//        for (i in fak.indices) {
//            if (fak.get(i).isuue === itemFaktorModel.isuue ) {
//                fak.subList(i,itemFaktorModel.isuue.toInt())
//                notifyItemChanged(i)
//            }
//        }
//    }
    class viewfinder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtissue:TextView = itemView.findViewById(R.id.issue)
        var txtnumber:TextView = itemView.findViewById(R.id.number)
        var txtxplan: TextView = itemView.findViewById(R.id.xplan)
        var txtmony: TextView = itemView.findViewById(R.id.mony)
        var txtmonyall: TextView = itemView.findViewById(R.id.monyall)




    }






}