package com.example.tankhah.core.rvm

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.tankhah.core.appmodule.ApplicationModule
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.tan.model
import javax.inject.Inject

class repositoryfokh @Inject constructor(private var context: Context){

    var use = ApplicationModule.provideDatabase(context)
    var usedao = use.dao
    fun insert(modelfokh: modelfokh) = usedao?.addfokh(modelfokh)
    fun inserthome(model: model) = usedao?.addhome(model)
    fun get() : LiveData<List<modelfokh>>? = usedao?.getfokh()
    fun gethome() : LiveData<List<model>>? = usedao?.gethome()
    fun search(query:String) : LiveData<List<modelfokh>>? = usedao?.search(query)
    fun update(modelfokh: modelfokh) : Int = usedao!!.update(modelfokh)
    fun deleteHome(model: model) : Int = usedao!!.deleteHome(model)
}