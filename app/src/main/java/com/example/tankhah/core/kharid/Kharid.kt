package com.example.tankhah.core.kharid

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.core.adapter.adapterfokh
import com.example.tankhah.core.dialog.dialogfokh
import com.example.tankhah.core.getmony
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.rvm.viewmodelfokh

import com.example.tankhah.databinding.FragmentKharidBinding
import dagger.hilt.android.AndroidEntryPoint
import ir.duck.hooshro.setting.BaseFragment
import ir.duck.hooshro.setting.SharePref
import javax.inject.Inject

@AndroidEntryPoint
class Kharid(fm:FragmentManager) : BaseFragment<FragmentKharidBinding>(com.example.tankhah.R.layout.fragment_kharid) , getmony{
    @Inject
    var str = "فاکتور خرید"
    var get:Int = 0
    private lateinit var recyclerView:RecyclerView
    val fm = fm
    override suspend fun onViewCreated() {
        binding.fab.setOnClickListener {
//            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                .setAction("Action", null)
//                .show()
//            var intent = Intent(context, FaktorActivity::class.java)
//            intent.putExtra("kharid","kharid")
//            startActivity

            val pop = dialogfokh(context?.applicationContext!!,str)

            pop.show(fm, "name")
        }



        recyclerView = binding.recycleviewkharid

        var linearLayoutManager: LinearLayoutManager

        linearLayoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = linearLayoutManager










//        var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }
//        viewmodel?.serach(str)?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {A->
//            var adapter = context?.let { adapterfokh(it, A ) }!!
//            recyclerView.adapter = adapter
//        })
        var sharePref:SharePref = SharePref(context?.applicationContext!!)
//        var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }
//            viewmodel?.serach(str)?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { A->
//                var adapter = context?.let { adapterfokh(it, A, this ) }!!
//                recyclerView.adapter = adapter
//                if (sharePref.get() == "1"){
//                    adapter.notifyDataSetChanged()
//                }
//            })
//    }
    var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }
    viewmodel?.get()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { A->
        var adapter = context?.let { adapterfokh(it, A, this ) }!!
        recyclerView.adapter = adapter
    })
}

    override fun getmonyall(a: Int) {
        get = a
    }


}