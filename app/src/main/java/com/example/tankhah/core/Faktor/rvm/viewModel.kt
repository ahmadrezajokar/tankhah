package com.example.tankhah.core.Faktor.rvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewModel(context: Context) : ViewModel() {
        var repasitory: repasitory = repasitory(context)

         fun insert(ItemFaktorModel: ItemFaktorModel) {
             viewModelScope.launch(Dispatchers.IO) {
                 repasitory.insert(ItemFaktorModel)
             }
         }
         fun get() : LiveData<List<ItemFaktorModel>> = repasitory.get()
         fun search(quary:String?) : LiveData<List<ItemFaktorModel>>? = repasitory.search(quary.toString())
   // suspend fun insertNote(note: Note) = repository.insertNote(note)

//         fun getQustion(): LiveData<List<itemfaktormodel>> {
////             return repasitoryQustion.setQustion()
//         }



}