package com.example.mydebts

import android.app.DatePickerDialog
import android.icu.number.NumberFormatter.DecimalSeparatorDisplay
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.mydebts.RoomDatabase.AppDatabase
import com.example.mydebts.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddDebt : AppCompatActivity() {
    private lateinit var tvDateDisplay: TextView
    private lateinit var btnPickDate: Button
    private lateinit var binding: AddDebt
    private lateinit var AppDb: AppDatabase
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_debt)

        val action2 = supportActionBar
        action2!!.title = "Add The Debt"

        tvDateDisplay = findViewById(R.id.tv_displayDate)
        btnPickDate = findViewById(R.id.btn_setDate)
        btnSave = findViewById(R.id.btn_save)

        val calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(calendar)
        }

        btnPickDate.setOnClickListener {
            DatePickerDialog(
                this, datePicker, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }


    }


    private fun updateLable(calendar: Calendar){
       val myFormat = "dd-MM-yyyy"
       val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvDateDisplay.setText("return until: "+sdf.format(calendar.time))
    }
}