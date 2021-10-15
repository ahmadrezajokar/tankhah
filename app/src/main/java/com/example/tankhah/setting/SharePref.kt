package ir.duck.hooshro.setting

import android.content.Context

class SharePref(val context: Context){

    val sharedPref = context.getSharedPreferences(
        "information", Context.MODE_PRIVATE)

    fun setidkharid(key:String){
        with (sharedPref.edit()) {
            putString("key", key)
            apply()
        }
    }
    fun set(keyf:String){
        with (sharedPref.edit()) {
            putString("keyf", keyf)
            apply()
        }
    }

    fun get(): String? = sharedPref.getString("keyf","")
    //fun getidforosh(): String = sharedPref.getString("keyf","0").toString()

    fun SetTextQustionA(xplan:String,number:String,mony:String,monyall:String){
        with (sharedPref.edit()) {
            putString("xplan", xplan)
            putString("number", number)
            putString("mony", mony)
            putString("monyall", monyall)
            apply()
        }
    }

    fun getTextxplan():String = sharedPref.getString("xplan","").toString()
    fun getTextnumber():String = sharedPref.getString("number","").toString()
    fun getTextmony():String = sharedPref.getString("mony","").toString()
    fun getTextmonyall():String = sharedPref.getString("monyall","").toString()
}