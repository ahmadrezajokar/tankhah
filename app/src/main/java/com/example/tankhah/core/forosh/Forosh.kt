package com.example.tankhah.core.forosh

import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R
import com.example.tankhah.core.adapter.adapterfokh
import com.example.tankhah.core.dialog.dialogfokh
import com.example.tankhah.core.getmony
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.rvm.viewmodelfokh
import com.example.tankhah.databinding.FragmentForoshBinding
import dagger.hilt.android.AndroidEntryPoint
import ir.duck.hooshro.setting.BaseFragment
import ir.duck.hooshro.setting.SharePref
import javax.inject.Inject

@AndroidEntryPoint
class Forosh(fm:FragmentManager) : BaseFragment<FragmentForoshBinding>(R.layout.fragment_forosh) ,getmony{

    @Inject
    var str = "فاکتور فروش"
    var get:Int = 0
    val fm = fm
    // var frag:FragmentManager = childFragmentManager
    private lateinit var recyclerView:RecyclerView
    override suspend fun onViewCreated() {

        binding.fab.setOnClickListener {
//            var intent = Intent(context, FaktorActivity::class.java)
//            intent.putExtra("forosh","forosh")
//            startActivity(intent)


            val pop = dialogfokh(context?.applicationContext!!,str)

            pop.show(fm, "name")

        }







        recyclerView = binding.recycleviewForosh

        var linearLayoutManager: LinearLayoutManager

        linearLayoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = linearLayoutManager

        var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }
        var sharePref: SharePref = SharePref(context?.applicationContext!!)
//        var modelfokh: modelfokh = modelfokh()
//        var s = sharePref.get()
//        modelfokh.monyall = s.toString()
//        viewmodel?.update(modelfokh)
            viewmodel?.serach(str)?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { A->
                var adapter = context?.let { adapterfokh(it, A ,this) }!!
                recyclerView.adapter = adapter
                if (sharePref.get() == "1"){
                    adapter.notifyDataSetChanged()
                }
            })

    }

    override fun getmonyall(a: Int) {
        get = a
    }
}


