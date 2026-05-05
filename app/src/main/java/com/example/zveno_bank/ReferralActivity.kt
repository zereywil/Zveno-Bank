package com.example.zveno_bank

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReferralActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referral)

        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        // Пример реферального кода
        Toast.makeText(this, "Ваш реферальный код: ZVENO123", Toast.LENGTH_LONG).show()
    }
}