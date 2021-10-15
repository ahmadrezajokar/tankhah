package com.example.tankhah.core.Faktor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tankhah.R
import com.example.tankhah.core.Faktor.adapter.adapterfaktor
import com.example.tankhah.core.Faktor.dialog.dialogfaktor
import com.example.tankhah.core.Faktor.rvm.viewModel
import com.example.tankhah.core.getmony
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.rvm.viewmodelfokh
import com.example.tankhah.databinding.ItemRecycleviewBinding
import ir.duck.hooshro.setting.SharePref
import java.lang.Exception
import com.example.tankhah.core.getdata as getdata

class FaktorActivity() : AppCompatActivity(),getdata{

    private var mony: Int = 0
    var keystr:String = ""
    var ga:Int = 0
    private lateinit var adapterfaktor: adapterfaktor
    private lateinit var sharePref:SharePref
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    lateinit var binding:ItemRecycleviewBinding
    private lateinit var fragment:FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_recycleview)
        binding =  DataBindingUtil.setContentView<ItemRecycleviewBinding>(this, R.layout.item_recycleview)

        var intent = intent
        if (intent.getStringExtra("kharid") == "فاکتور خرید"){
            binding.txtToolbar.text = "فاکتور خرید"
            keystr = "1"
        }else if(intent.getStringExtra("kharid") == "فاکتور فروش"){
            binding.txtToolbar.text = "فاکتور فروش"
            keystr = "2"
        }
        sharePref = SharePref(this)
        binding.txtNameFaktor.setText(intent.getStringExtra("name"))
        binding.txtNamecompany.setText(intent.getStringExtra("company"))
        binding.txtDataFaktor.setText(intent.getStringExtra("data"))
        binding.txtTimeFaktor.setText(intent.getStringExtra("time"))
        binding.txtcodegh.setText(intent.getStringExtra("codegh"))
        binding.numberfaktors.setText(intent.getStringExtra("number"))
//        binding.txtmonyallfaktor.setText(sharePref.get())

        var viewmodel  = applicationContext?.let { viewModel(it.applicationContext) }



        recyclerView = binding.recycleviewFaktor

        var linearLayoutManager: LinearLayoutManager

        linearLayoutManager = LinearLayoutManager(applicationContext)

        recyclerView.layoutManager = linearLayoutManager

//        viewmodel?.get()?.observe(this, Observer { abs ->
//            var adapter = applicationContext?.let { adapter(it, abs as ArrayList<itemfaktormodel>) }
//
//            recyclerView.adapter = adapter
//        }


        viewmodel?.search(intent.getStringExtra("number"))?.observe(this, { AB->
            adapterfaktor = applicationContext?.let { adapterfaktor(it, AB ,sharePref , this) }!!
            recyclerView.adapter = adapterfaktor
            binding.txtmonyallfaktor.text = "0"

            try {
//                    var sa  = AB.get(this.ga).monyall
//                    var finish = sa + sharePref.get()
//                    binding.txtmonyallfaktor.text = (finish).toString()
                var m = 0
    AB.forEach {
                    var s = it.monyall + m
                    binding.txtmonyallfaktor.text = s.toString()
                    m = s

                }
            }catch (e:Exception){

            }

        })


        binding.fabAddItemFaktorSusses.setOnClickListener {
        //    var s = intent.getStringExtra("number")?.toInt()
            if (intent.getStringExtra("number")?.indices != null){
//                var viewmodel:viewmodelfokh = viewmodelfokh(applicationContext)
//               var  modelfokh:modelfokh = modelfokh()
//                viewmodel.update(modelfokh)
             //   Log.e("ahmadreza", "onViewCreated: ${modelfokh.monyall}")
                finish()
            }
            finish()
        }
        binding.fabAddItemFaktorAdd.setOnClickListener {

            val pop = dialogfaktor(
                keystr,binding.numberfaktors.text.toString().trim())
            val fm:FragmentManager = supportFragmentManager
            pop.show(fm, "name")

        }



//        binding.btnSussFaktor.setOnClickListener {
//            var viewmodel  = applicationContext?.let { viewmodelfokh(it.applicationContext) }
//            var modelfokh:modelfokh = modelfokh()
//            var itemFaktorModel:itemFaktorModel= itemFaktorModel()
//            modelfokh.numberfaktor = itemFaktorModel.isuue.toString()
//            modelfokh.namefaktor   = itemFaktorModel.keystr
//            modelfokh.namecompany  = binding.txtNamecompany.text.toString().trim()
//            modelfokh.monyall      = itemFaktorModel.monyall
//            viewmodel?.insert(modelfokh)
//            finish()
//        }
    }

    override fun getposition(a: Int) {
        ga = a
    }





//    override fun add(tr: Boolean) {
////        if (tr == true){
////            var viewmodel  = applicationContext?.let { ViewModelQustion(it.applicationContext) }
////            viewmodel?.getModel()?.observe(this, androidx.lifecycle.Observer {AB->
////                adapter = applicationContext?.let { adapter(it, AB ,sharePref)}!!
////                recyclerView.adapter = adapter
////            })
////        }else{
////            tr.and(false)
////        }
//    }




}