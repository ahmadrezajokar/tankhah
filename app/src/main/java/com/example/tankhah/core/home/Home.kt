package com.example.tankhah.core.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R
import com.example.tankhah.core.adapter.adapterfokh
import com.example.tankhah.core.dialog.dialogfokh
import com.example.tankhah.core.rvm.viewmodelfokh
import com.example.tankhah.core.tan.adapter
import com.example.tankhah.databinding.FragmentFaktorBinding
import com.example.tankhah.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import ir.duck.hooshro.setting.BaseFragment
import javax.inject.Inject


class Home (fm:FragmentManager) : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    var fm = fm

    override fun onViewCreated() {


        binding.fab.setOnClickListener { view ->
            var dialogfokh: dialogfokh = dialogfokh(context?.applicationContext!!,"تنخواه")
            dialogfokh.show(fm,"namehome")
        }
        var recyclerView: RecyclerView
        recyclerView = binding.recycleviewHome

        var linearLayoutManager: LinearLayoutManager

        linearLayoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = linearLayoutManager
        var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }

//        viewmodel?.gethome()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { list->
//            var adapter = context?.let { adapter(it, list,fm) }
//            recyclerView.adapter = adapter
//        })

    }
}