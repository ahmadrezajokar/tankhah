package com.example.tankhah.core.Faktor.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemFaktorModel")
data class ItemFaktorModel (
    @PrimaryKey(autoGenerate = true)
    var isuue:Long = 0,
    var xplan:String = "",
    var number:String = "",
    var mony:String = "",
    var monyall:Int = 0,
    var keystr:String = "",
    var numberfaktorcode:String = ""
        ) {


}



//    override fun equals(other: Any?): Boolean {
//
//        if (javaClass != other?.javaClass){
//            return false
//        }
//
//        other as itemfaktormodel
//
//        if (isuue != other.isuue){
//            return false
//        }
//        if (xplan != other.xplan){
//            return false
//        }
//        if (number != other.number){
//            return false
//        }
//        if (mony != other.mony){
//            return false
//        }
//        if (monyall != other.monyall){
//            return false
//        }
//
//        return true
//    }
