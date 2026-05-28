package com.example.zveno_bank

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class SavingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings)

        // Кнопка назад
        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        // Текущая цель
        val goalTitle = findViewById<TextView>(R.id.goal_title)
        val goalProgress = findViewById<TextView>(R.id.goal_progress)

        goalTitle.text = "Новая машина"
        goalProgress.text = "150 000 ₽ / 500 000 ₽"

        // Кнопки копилок
        val piggyBank1 = findViewById<MaterialCardView>(R.id.piggy_bank_1)
        val piggyBank2 = findViewById<MaterialCardView>(R.id.piggy_bank_2)

        piggyBank1.setOnClickListener {
            Toast.makeText(this, "Копилка 'Отпуск': 25 000 ₽", Toast.LENGTH_SHORT).show()
        }

        piggyBank2.setOnClickListener {
            Toast.makeText(this, "Копилка 'Подушка безопасности': 100 000 ₽", Toast.LENGTH_SHORT).show()
        }

        // Кнопка добавить цель
        val addGoalButton = findViewById<Button>(R.id.add_goal_button)
        addGoalButton.setOnClickListener {
            Toast.makeText(this, "Создать новую цель", Toast.LENGTH_SHORT).show()
        }
    }
}