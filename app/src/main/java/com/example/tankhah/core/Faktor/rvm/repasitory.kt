package com.example.tankhah.core.Faktor.rvm

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import com.example.tankhah.core.database.DataBase

class repasitory(private val context: Context) {

//    private var ma = MutableLiveData<List<itemfaktormodel>>()
//    private var list = arrayListOf<itemfaktormodel>()
//    private val sharePref:SharePref = SharePref(context)
    private val database = DataBase.invoke(context)
    private val userDao = database.dao

//    fun insert() : LiveData<List<itemfaktormodel>> {
//
//
////        var list = ArrayList<itemfaktormodel>()
//       // list.addAll(users)
//      //  ma.value = list
//      //  return ma
////        ma.value = users
////        return ma
//    }

     fun insert(ItemFaktorModel: ItemFaktorModel) = userDao?.add(ItemFaktorModel)
     fun get() : LiveData<List<ItemFaktorModel>> = userDao!!.get()
     fun search(quary:String) : LiveData<List<ItemFaktorModel>>? = userDao?.searchitem(quary)
//    suspend fun insertNote(note: Note) = noteDatabase.getNoteDao().insertNote(note)
//    suspend fun insertNote(note: Note) = noteDatabase.getNoteDao().insertNote(note)



}



