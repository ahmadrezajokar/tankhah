package com.example.tankhah.core.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.tankhah.R
import com.example.tankhah.core.model.modelfokh
import com.example.tankhah.core.rvm.viewmodelfokh
import com.example.tankhah.core.tan.model
import com.example.tankhah.setting.datasx
import ir.duck.hooshro.setting.SharePref
import java.text.SimpleDateFormat
import java.util.*

class dialogfokh(context:Context,str:String) : DialogFragment() {


    private var str:String = str

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(context)

        val view:View = View.inflate(context,R.layout.itemdialogfokh,null)

        builder.setView(view)

        val code_egh:EditText = view.findViewById(R.id.edit_code_egh)

        val name_company:EditText = view.findViewById(R.id.edit_name_company)

        val nameaccunt:EditText = view.findViewById(R.id.nameaccunt)

        val data:TextView = view.findViewById(R.id.txt_data)

        val name_faktor:TextView = view.findViewById(R.id.name_faktor)
        name_faktor.text = str

        val clock:TextView = view.findViewById(R.id.txt_clock)

        val btn_suss:Button = view.findViewById(R.id.btn_suss)

        val btn_exit:Button = view.findViewById(R.id.btn_exit)



        val year = SimpleDateFormat("yyyy")
        val yearMilade = year.format(Date())
        val month = SimpleDateFormat("MM")
        val monthMilade = month.format(Date())
        val day = SimpleDateFormat("dd")
        val dayMilade = day.format(Date())
        val converter = datasx()
        converter.gregorianToPersian(yearMilade.toInt(), monthMilade.toInt(), dayMilade.toInt())
        val converterYear: Int = converter.getYear()
        val converterMonth: Int = converter.getMonth()
        val converterDay: Int = converter.getDay()

        val calendar = Calendar.getInstance()
        val hours = calendar[Calendar.HOUR]
        val minutes = calendar[Calendar.MINUTE]
        val second = calendar[Calendar.SECOND]
        clock.text = "$hours:$minutes:$second"
        data.text = "$converterYear/$converterMonth/$converterDay"
        btn_exit.setOnClickListener {

            dismiss()

        }

        btn_suss.setOnClickListener {
//            if (str == "تنخواه"){
                var viewmodel  = context?.let { viewmodelfokh(it.applicationContext) }

                var model: model = model()

                model.txtnamecompany  = name_company.text.toString().trim()

                model.txtdatafaktor = data.text.toString().trim()

                model.txttimefaktor = clock.text.toString().trim()

                model.nameaccuntada = nameaccunt.text.toString().trim()

                viewmodel?.inserthome(model)

                dismiss()
//            }else{
//                var viewmodel  = context?.let { viewmodelfokh(it.applicationContext) }
//
//                var modelfokh: modelfokh = modelfokh()
//
//                // modelfokh.numberfaktor = modelfokh.isuue.toString()
//
//                modelfokh.namefaktor   = str
//
//                modelfokh.namecompany  = name_company.text.toString().trim()
//
//                modelfokh.code_gh = code_egh.text.toString().trim()
//
//                modelfokh.data = data.text.toString().trim()
//
//                modelfokh.time = clock.text.toString().trim()
//
//                modelfokh.nameaccunt = nameaccunt.text.toString().trim()
//
//                viewmodel?.insert(modelfokh)

                //      sharePref.SetTextQustionA(editXplan.text.toString(),editnumber.text.toString(),editmony.text.toString(),editmonyall.text.toString())

                dismiss()
            }


        return builder.create()

    }


}