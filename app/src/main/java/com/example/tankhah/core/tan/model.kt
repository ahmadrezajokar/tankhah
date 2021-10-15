package com.example.tankhah.core.tan

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "mo")
class model(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var monyallada:String = "",
    var txtnamecompany:String = "",
    var txtdatafaktor:String = "",
    var txttimefaktor:String = "",
    var nameaccuntada:String = "",
    var txtnumberfaktor:String = "",
)