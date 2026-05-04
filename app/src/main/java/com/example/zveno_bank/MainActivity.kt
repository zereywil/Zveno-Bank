package com.example.zveno_bank // Замени на свое название пакета

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Находим наши кнопки по айди
        val payButton = findViewById<Button>(R.id.btn_pay)
        val transferButton = findViewById<Button>(R.id.btn_transfer)

        // Вешаем слушатель нажатий
        payButton.setOnClickListener {
            Toast.makeText(this, "Оплата: Продуктовый магазин", Toast.LENGTH_SHORT).show()
        }

        transferButton.setOnClickListener {
            Toast.makeText(this, "Перевод: Выбор контакта...", Toast.LENGTH_SHORT).show()
        }

        // Так сделаем для кнопок "Пополнить" и "История" по аналогии
        findViewById<Button>(R.id.btn_topup).setOnClickListener {
            Toast.makeText(this, "Пополнение с карты", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btn_more).setOnClickListener {
            Toast.makeText(this, "Здесь будет история операций", Toast.LENGTH_SHORT).show()
        }
    }
}