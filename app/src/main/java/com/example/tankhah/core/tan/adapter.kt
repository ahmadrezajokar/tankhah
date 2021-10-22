package com.example.tankhah.core.tan

import android.content.Context
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
import com.example.tankhah.R
import com.example.tankhah.core.rvm.viewmodelfokh

class adapter(private var context:Context,private var list: List<model> = emptyList(), private var f:FragmentManager)
    : DragDropSwipeAdapter<model, adapter.ViewHolder>(list) {


    private var fm = f
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
//        val inflater = LayoutInflater.from(context)
//        val view = inflater.inflate(R.layout.item_tankhah, parent, false)
//        return adapter.Viewholder(view)
//    }
//
//    override fun onBindViewHolder(holder: Viewholder, position: Int) {
//
//    }
//
//    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView){
        var txtnamecompany: TextView = itemView.findViewById(R.id.namrcompanyada)
        var txtdatafaktor: TextView = itemView.findViewById(R.id.dataada)
        var txttimefaktor: TextView = itemView.findViewById(R.id.timeada)
        var txtnumberfaktor: TextView = itemView.findViewById(R.id.numberfaktorada)
        var monyallada: TextView = itemView.findViewById(R.id.monyallada)
        var nameaccuntada: TextView = itemView.findViewById(R.id.nameaccuntada)
        var crd_home: CardView = itemView.findViewById(R.id.crd_home)

    }

    override fun getViewHolder(itemLayout: View) = adapter.ViewHolder(itemLayout)

    override fun getViewToTouchToStartDraggingItem(
        item: model,
        viewHolder: ViewHolder,
        position: Int
    ): View? {
        return viewHolder.crd_home
    }

    override fun onBindViewHolder(item: model, viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            txtnamecompany.text = list.get(position).txtnamecompany
            txtdatafaktor.text = list.get(position).txtdatafaktor
            txttimefaktor.text = list.get(position).txttimefaktor
            txtnumberfaktor.text = list.get(position).txtnumberfaktor
            nameaccuntada.text = list.get(position).nameaccuntada
            monyallada.text = list.get(position).monyallada
        }

    }

    override fun onDragStarted(item: model, viewHolder: ViewHolder) {
      //  var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }!!
//        var model = item
//        viewmodel?.deleteHome(model)
        super.onDragStarted(item, viewHolder)

    }
    
}