package com.example.zveno_bank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Кнопка назад
        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        // Поля для ввода
        val amountInput = findViewById<EditText>(R.id.credit_amount)
        val periodInput = findViewById<EditText>(R.id.credit_period)
        val calculateButton = findViewById<Button>(R.id.calculate_button)

        // Рассчитать кредит
        calculateButton.setOnClickListener {
            val amountText = amountInput.text.toString()
            val periodText = periodInput.text.toString()

            if (amountText.isNotEmpty() && periodText.isNotEmpty()) {
                val amount = amountText.toDoubleOrNull()
                val period = periodText.toIntOrNull()

                if (amount != null && period != null) {
                    val monthlyPayment = (amount / period / 1.1) // Простая формула с процентами
                    Toast.makeText(
                        this,
                        "Ежемесячный платёж: ${String.format("%.0f", monthlyPayment)} ₽",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        // Предложения кредитов
        setupCreditOffers()
    }

    private fun setupCreditOffers() {
        val offer1 = findViewById<MaterialCardView>(R.id.offer_1)
        val offer2 = findViewById<MaterialCardView>(R.id.offer_2)

        offer1.setOnClickListener {
            Toast.makeText(this, "Кредит наличными до 1 000 000 ₽", Toast.LENGTH_SHORT).show()
        }

        offer2.setOnClickListener {
            Toast.makeText(this, "Ипотека от 5%", Toast.LENGTH_SHORT).show()
        }
    }
}