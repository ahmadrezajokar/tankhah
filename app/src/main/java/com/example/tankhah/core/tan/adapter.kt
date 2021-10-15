package com.example.tankhah.core.tan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R

class adapter(private var context:Context,
private var list: List<model>
,
private var f:FragmentManager) :
    RecyclerView.Adapter<adapter.viewfingeritem>() {

    private var fm = f
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter.viewfingeritem {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_tankhah, parent, false)
        return adapter.viewfingeritem(view)
    }

    override fun onBindViewHolder(holder: adapter.viewfingeritem, position: Int) {
        holder.apply {
            txtnamecompany.text = list.get(position).txtnamecompany
            txtdatafaktor.text = list.get(position).txtdatafaktor
            txttimefaktor.text = list.get(position).txttimefaktor
            txtnumberfaktor.text = list.get(position).txtnumberfaktor
            nameaccuntada.text = list.get(position).nameaccuntada
            monyallada.text = list.get(position).monyallada
        }
    }

    override fun getItemCount(): Int = list.size



    class viewfingeritem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtnamecompany: TextView = itemView.findViewById(R.id.namrcompanyada)
        var txtdatafaktor: TextView = itemView.findViewById(R.id.dataada)
        var txttimefaktor: TextView = itemView.findViewById(R.id.timeada)
        var txtnumberfaktor: TextView = itemView.findViewById(R.id.numberfaktorada)
        var monyallada: TextView = itemView.findViewById(R.id.monyallada)
        var nameaccuntada: TextView = itemView.findViewById(R.id.nameaccuntada)

    }


    }