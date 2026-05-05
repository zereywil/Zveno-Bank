package com.example.zveno_bank

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OperationDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation_detail)

        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        val operation = intent.getStringExtra("operation") ?: "Операция"
        val amount = intent.getStringExtra("amount") ?: "0 ₽"
        val date = intent.getStringExtra("date") ?: "Дата неизвестна"

        findViewById<TextView>(R.id.operation_title).text = operation
        findViewById<TextView>(R.id.operation_amount).text = amount
        findViewById<TextView>(R.id.operation_date).text = date
    }
}