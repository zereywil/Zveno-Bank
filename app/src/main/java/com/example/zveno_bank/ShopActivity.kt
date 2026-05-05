package com.example.zveno_bank

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        findViewById<ImageView>(R.id.back_button).setOnClickListener { finish() }
        Toast.makeText(this, "Витрина товаров", Toast.LENGTH_SHORT).show()
    }
}