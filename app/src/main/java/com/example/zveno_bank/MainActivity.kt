package com.example.zveno_bank

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Профиль
        findViewById<LinearLayout>(R.id.profile_container).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Реферальная кнопка
        findViewById<ImageView>(R.id.referral_button).setOnClickListener {
            startActivity(Intent(this, ReferralActivity::class.java))
        }

        // Кнопки быстрых действий
        findViewById<Button>(R.id.btn_pay).setOnClickListener {
            startActivity(Intent(this, PaymentsActivity::class.java))
        }

        findViewById<Button>(R.id.btn_transfer).setOnClickListener {
            startActivity(Intent(this, TransferActivity::class.java))
        }

        findViewById<Button>(R.id.btn_topup).setOnClickListener {
            Toast.makeText(this, "Пополнение карты", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btn_more).setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        // Нижняя навигация
        setupBottomNavigation()

        // Последние операции
        setupLastOperationsClick()
    }

    private fun setupBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.nav_home)
        val navPayments = findViewById<LinearLayout>(R.id.nav_payments)
        val navCity = findViewById<LinearLayout>(R.id.nav_city)
        val navChat = findViewById<LinearLayout>(R.id.nav_chat)
        val navShop = findViewById<LinearLayout>(R.id.nav_shop)

        navHome.setOnClickListener {
            Toast.makeText(this, "Главная", Toast.LENGTH_SHORT).show()
            highlightNavItem(R.id.nav_home)
        }

        navPayments.setOnClickListener {
            startActivity(Intent(this, PaymentsActivity::class.java))
            highlightNavItem(R.id.nav_payments)
        }

        navCity.setOnClickListener {
            startActivity(Intent(this, CityActivity::class.java))
            highlightNavItem(R.id.nav_city)
        }

        navChat.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
            highlightNavItem(R.id.nav_chat)
        }

        navShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
            highlightNavItem(R.id.nav_shop)
        }
    }

    private fun highlightNavItem(activeId: Int) {
        val navItems = listOf(
            R.id.nav_home, R.id.nav_payments, R.id.nav_city, R.id.nav_chat, R.id.nav_shop
        )

        for (id in navItems) {
            val item = findViewById<LinearLayout>(id)
            val icon = item.getChildAt(0) as ImageView
            val text = item.getChildAt(1) as TextView

            if (id == activeId) {
                icon.setColorFilter(Color.parseColor("#6D28D9"))
                text.setTextColor(Color.parseColor("#6D28D9"))
            } else {
                icon.setColorFilter(Color.parseColor("#888888"))
                text.setTextColor(Color.parseColor("#888888"))
            }
        }
    }

    private fun setupLastOperationsClick() {
        val operationCafe = findViewById<TextView>(R.id.operation_cafe)
        val operationTransfer = findViewById<TextView>(R.id.operation_transfer)
        val operationTopup = findViewById<TextView>(R.id.operation_topup)

        operationCafe.setOnClickListener {
            val intent = Intent(this, OperationDetailActivity::class.java)
            intent.putExtra("operation", "Оплата кафе")
            intent.putExtra("amount", "-850 ₽")
            intent.putExtra("date", "12.05.2024")
            startActivity(intent)
        }

        operationTransfer.setOnClickListener {
            val intent = Intent(this, OperationDetailActivity::class.java)
            intent.putExtra("operation", "Перевод Даниэлю")
            intent.putExtra("amount", "-5000 ₽")
            intent.putExtra("date", "10.05.2024")
            startActivity(intent)
        }

        operationTopup.setOnClickListener {
            val intent = Intent(this, OperationDetailActivity::class.java)
            intent.putExtra("operation", "Пополнение с карты")
            intent.putExtra("amount", "+10000 ₽")
            intent.putExtra("date", "08.05.2024")
            startActivity(intent)
        }
    }
}