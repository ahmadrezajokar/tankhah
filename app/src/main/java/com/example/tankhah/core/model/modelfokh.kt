package com.example.tankhah.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "modelfokh")
data class modelfokh (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var namefaktor:String = "",
    var numberfaktor:String = "",
    var namecompany:String = "",
    var nameaccunt:String = "",
    var code_gh:String = "",
    var data:String = "",
    var monyall:String = "",
    var time:String = "",
)