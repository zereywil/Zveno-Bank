package com.example.zveno_bank

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class InvestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invest)

        // Кнопка назад
        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        // Портфель инвестора
        val portfolioValue = findViewById<TextView>(R.id.portfolio_value)
        portfolioValue.text = "124 500 ₽"

        // Акции
        val stockItem = findViewById<MaterialCardView>(R.id.stock_item)
        stockItem.setOnClickListener {
            Toast.makeText(this, "Акции Сбера: +2.5% сегодня", Toast.LENGTH_SHORT).show()
        }

        // Облигации
        val bondItem = findViewById<MaterialCardView>(R.id.bond_item)
        bondItem.setOnClickListener {
            Toast.makeText(this, "ОФЗ 26233: доходность 8.5%", Toast.LENGTH_SHORT).show()
        }

        // Кнопка пополнения
        findViewById<MaterialCardView>(R.id.invest_button).setOnClickListener {
            Toast.makeText(this, "Пополнить инвестиционный счёт", Toast.LENGTH_SHORT).show()
        }
    }
}