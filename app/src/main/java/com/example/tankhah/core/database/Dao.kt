package com.example.tankhah.core.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.tan.model
import java.nio.charset.CodingErrorAction.REPLACE

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun add(ItemFaktorModel: ItemFaktorModel)

//    @Delete
//    fun delete(itemFaktorModel: itemFaktorModel)
//
//    @Update
//    fun update(itemFaktorModel: itemFaktorModel)

//    @Query(" SELECT * FROM tblGameHome WHERE userId LIKE '%' || :query || '%' ")
//    fun search(query: String?): List<itemfaktormodel?>?
//
    @Query("SELECT * FROM itemfaktormodel ")
     fun get(): LiveData<List<ItemFaktorModel>>
    @Query(" SELECT * FROM itemfaktormodel WHERE  numberfaktorcode = :query ")
    fun searchitem(query: String?): LiveData<List<ItemFaktorModel>>

//    @Query("DELETE FROM  tblGameHome")
//    fun deleteALL()

//

//    @Insert
//    fun addfokh(modelfokh: modelfokh)


    @Insert
     fun addfokh(modelfokh: modelfokh)

    @Query("SELECT * FROM modelfokh ")
     fun getfokh(): LiveData<List<modelfokh>>


    @Update
     fun update(modelfokh: modelfokh)


//    @Query(" SELECT * FROM modelfokh WHERE  LIKE '%' || :query || '%' ")
    @Query(" SELECT * FROM modelfokh WHERE  namefaktor LIKE '%' || :query || '%' ")
     fun search(query: String?): LiveData<List<modelfokh>>

//    @Query("SELECT * FROM modelfokh ")
//    fun getfokh(): LiveData<List<modelfokh>>

//    @Query(" SELECT * FROM modelfokh WHERE id LIKE '%' || :query || '%' ")
//    fun search(query: String?): LiveData<List<modelfokh>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addhome(model:model)

    @Query(" SELECT * FROM mo ")
     fun gethome(): LiveData<List<model>>

}
