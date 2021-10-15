package com.example.tankhah.core.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R
import com.example.tankhah.core.Faktor.view.FaktorActivity
import com.example.tankhah.core.getmony
import com.example.tankhah.core.model.modelfokh
import ir.duck.hooshro.setting.SharePref

class adapterfokh(private var context: Context,
                  private var list: List<modelfokh>,getmony: getmony) :
    RecyclerView.Adapter<adapterfokh.viewfingerfokh>() {

    var get:getmony = getmony
    var sharePref:SharePref = SharePref(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewfingerfokh {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_recycleview_fokh_faktor, parent, false)
        return adapterfokh.viewfingerfokh(view)
    }

    override fun onBindViewHolder(holder: viewfingerfokh, position: Int) {
        holder.apply {
            number.text = list.get(position).id.toString()
            namefaktor.text = list.get(position).namefaktor
            namrcompany.text = list.get(position).namecompany
            monyall.text = list.get(position).monyall
            name.text = list.get(position).nameaccunt
            time.text = list.get(position).time
            data.text = list.get(position).data



        }
        holder.apply {
            itemView.setOnClickListener {
//                val pop = Faktordialog(context,keystr)
//                val fm: FragmentManager = fm
//                pop.show(fm, "name")
//                Toast.makeText(context,"ahmadreza", Toast.LENGTH_SHORT).show()

            var intent = Intent(context, FaktorActivity::class.java)
            intent.putExtra("kharid",list.get(position).namefaktor)
            intent.putExtra("number",list.get(position).id.toString())
            intent.putExtra("name",list.get(position).nameaccunt)
            intent.putExtra("company",list.get(position).namecompany)
            intent.putExtra("data",list.get(position).data)
            intent.putExtra("time",list.get(position).time)
            intent.putExtra("codegh",list.get(position).code_gh)
            context.startActivity(intent)
            get.getmonyall(list.get(position).id)

            }
        }


    }


    override fun getItemCount(): Int = list.size

    class viewfingerfokh(itemView: View) : RecyclerView.ViewHolder(itemView){
        var number:TextView = itemView.findViewById(R.id.numberfaktor)
        var namefaktor:TextView = itemView.findViewById(R.id.namefaktor)
        var namrcompany:TextView = itemView.findViewById(R.id.namrcompany)
        var monyall:TextView = itemView.findViewById(R.id.monyall)
        var name:TextView = itemView.findViewById(R.id.nameaccunt)
        var time:TextView = itemView.findViewById(R.id.time)
        var data:TextView = itemView.findViewById(R.id.data)

    }




}