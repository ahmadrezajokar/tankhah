package com.example.tankhah.core.Faktor.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.tankhah.R
import com.example.tankhah.core.Faktor.model.ItemFaktorModel
import com.example.tankhah.core.Faktor.rvm.viewModel
import ir.duck.hooshro.setting.SharePref
import java.lang.Exception
import java.text.DecimalFormat

class dialogfaktor( keystr:String, number:String) : DialogFragment() {


    private var keystr = keystr
    private var number = number
    private lateinit var viewmodel: viewModel
    private lateinit var numbercode:EditText
    private lateinit var mony:EditText
    private lateinit var monyall:TextView
    private lateinit var tomanmony:TextView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        viewmodel =  viewModel(context?.applicationContext!!)
        val view: View = View.inflate(context, R.layout.itemdialogfaktor,null)

        builder.setView(view)

        val editXplan: EditText = view.findViewById(R.id.edit_xplan)

        numbercode = view.findViewById(R.id.edit_number)

        mony  = view.findViewById(R.id.edit_mony)
        mony.addTextChangedListener(textWatcher)
        monyall = view.findViewById(R.id.edit_monyall)

        tomanmony = view.findViewById(R.id.tomanmony)
//        var s = splitDigits(mony.text.toString().toInt()).toString()
//        tomanmony.text = s


        val btn_suss: Button = view.findViewById(R.id.btn_suss)

        val btn_exit: Button = view.findViewById(R.id.btn_exit)


        btn_exit.setOnClickListener {

            dismiss()

        }

        btn_suss.setOnClickListener {

            if (numbercode.text.isNotEmpty()&&editXplan.text.isNotEmpty()&&mony.text.isNotEmpty()){
                getdatacode()
                var itemfaktormodel = ItemFaktorModel()
                itemfaktormodel.xplan = editXplan.text.toString()
                itemfaktormodel.number = numbercode.text.toString()
//                var s = splitDigits().toString()
                itemfaktormodel.mony = mony.text.toString()
//              var sharePref:SharePref =SharePref(context?.applicationContext!!)
//               sharePref.set(monyall.text.toString().toInt())
                itemfaktormodel.monyall = monyall.text.toString().toInt()
                itemfaktormodel.keystr = keystr
                itemfaktormodel.numberfaktorcode = number
                viewmodel.insert(itemfaktormodel)

                //      sharePref.SetTextQustionA(editXplan.text.toString(),editnumber.text.toString(),editmony.text.toString(),editmonyall.text.toString())

                dismiss()

            }else{
                Toast.makeText(context,"جاهای خالی راپرکنید", Toast.LENGTH_LONG).show()

            }

        }

        return builder.create()
    }

    fun getdatacode(){
        val monyint:Int = mony.text.toString().toInt()
        val numbercodeint:Int = numbercode.text.toString().toInt()
        val all = numbercodeint * monyint
//        var s = splitDigits(all.toString().toInt())
        monyall.text = all.toString()



    }
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
          try {
              var s = splitDigits(s.toString().toInt())
              tomanmony.text =" $s ریال "

          }catch (e:Exception){

          }


        }
    }

    fun splitDigits(number: Int): String? {
        return DecimalFormat("###,###,###").format(number)
    }


}