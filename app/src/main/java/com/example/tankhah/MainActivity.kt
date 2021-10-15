package com.example.tankhah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tankhah.core.dialog.dialogfokh
import com.example.tankhah.core.forosh.Forosh
import com.example.tankhah.core.home.Home
import com.example.tankhah.core.kharid.Kharid
import com.example.tankhah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var fm:FragmentManager = supportFragmentManager
    var home: Home = Home(fm)
    var kharid: Kharid = Kharid(fm)
    var forosh: Forosh = Forosh(fm)
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =  DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        val frag: faktor = faktor()
//        if(savedInstanceState == null) { // initial transaction should be wrapped like this
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.toolbar, frag)
//                .commitAllowingStateLoss()
//        }

        binding.bottomBar.onTabSelected = {
            when(it.title){
                "خانه" -> fragment(home)
                "خرید" -> fragment(kharid)
//                "فروش" -> fragment(forosh)
            }
        }

    }

    fun fragment(frag:Fragment){
            supportFragmentManager.beginTransaction()
                .replace(R.id.relParent, frag)
                .commitAllowingStateLoss()
    }
}