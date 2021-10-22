package com.example.tankhah.core.rvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.tan.model
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class viewmodelfokh @Inject constructor(@ApplicationContext context: Context) : ViewModel(){
    var repositoryfokh:repositoryfokh= repositoryfokh(context)
  fun insert(modelfokh: modelfokh){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryfokh.insert(modelfokh)
        }
    }
     fun inserthome(model: model){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryfokh.inserthome(model)
        }
    }
    fun get (): LiveData<List<modelfokh>>? = repositoryfokh.get()
     fun gethome (): LiveData<List<model>>? = repositoryfokh.gethome()

     fun serach(query:String) : LiveData<List<modelfokh>>? = repositoryfokh.search(query)

     fun update (modelfokh: modelfokh)  {
        viewModelScope.launch(Dispatchers.IO) {
               repositoryfokh.update(modelfokh)
        }
    }

    fun deleteHome(model: model) {
        viewModelScope.launch(Dispatchers.IO){
            repositoryfokh.deleteHome(model)
        }
    }

}