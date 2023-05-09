package com.example.dobapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var SelectedDate : TextView?=null
    private var tvageinmin : TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SelectedDate=findViewById(R.id.display)
        tvageinmin=findViewById(R.id.tvageinmin)
        val datePicker : Button =findViewById(R.id.buttonDate)
        datePicker.setOnClickListener{
            clickDatePicker()

        }
    }
        fun clickDatePicker()
        {  val myCalader=Calendar.getInstance()
           val year=myCalader.get(Calendar.YEAR)
            val month=myCalader.get(Calendar.MONTH)
            var day=myCalader.get(Calendar.DAY_OF_MONTH)
            var dpd=DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth ->
                    Toast.makeText(this,"ButDate Pressed", Toast.LENGTH_LONG).show()
                    var Selecteddate="$dayOfMonth/${month+1}/$year"
                    SelectedDate?.text=(Selecteddate)



                    var sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    var theDate=sdf.parse(Selecteddate)
                    var SelectedDateinMin=theDate.time/60000
                    var currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                    var currentDateInMin=currentDate.time/60000
                    var differnceinMin=currentDateInMin-SelectedDateinMin
                    tvageinmin?.text=differnceinMin.toString()

                },
                year,month,day)
            dpd.show()
            dpd.datePicker.maxDate=System.currentTimeMillis()-86400000



        }



}

