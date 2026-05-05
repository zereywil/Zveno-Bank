package com.example.zveno_bank

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val phoneInput = findViewById<EditText>(R.id.phone_input)
        val amountInput = findViewById<EditText>(R.id.amount_input)
        val transferButton = findViewById<android.widget.Button>(R.id.transfer_button)
        val backButton = findViewById<ImageView>(R.id.back_button)

        backButton.setOnClickListener {
            finish()
        }

        // Быстрые контакты - правильный синтаксис без listOf с парами
        val contactDaniel = findViewById<MaterialCardView>(R.id.contact_daniel)
        val contactMom = findViewById<MaterialCardView>(R.id.contact_mom)
        val contactFriend = findViewById<MaterialCardView>(R.id.contact_friend)

        contactDaniel.setOnClickListener {
            phoneInput.setText("+7 999 123-45-67")
            Toast.makeText(this, "Выбран контакт: Даниэль", Toast.LENGTH_SHORT).show()
        }

        contactMom.setOnClickListener {
            phoneInput.setText("+7 999 765-43-21")
            Toast.makeText(this, "Выбран контакт: Мама", Toast.LENGTH_SHORT).show()
        }

        contactFriend.setOnClickListener {
            phoneInput.setText("+7 999 111-22-33")
            Toast.makeText(this, "Выбран контакт: Друг", Toast.LENGTH_SHORT).show()
        }

        transferButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            val amountText = amountInput.text.toString()

            if (phone.isEmpty()) {
                phoneInput.error = "Введите номер телефона"
                return@setOnClickListener
            }

            if (amountText.isEmpty()) {
                amountInput.error = "Введите сумму"
                return@setOnClickListener
            }

            val amount = amountText.toDoubleOrNull()
            if (amount == null || amount <= 0) {
                amountInput.error = "Введите корректную сумму"
                return@setOnClickListener
            }

            showConfirmDialog(phone, amount)
        }
    }

    private fun showConfirmDialog(phone: String, amount: Double) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("Подтверждение перевода")
            .setMessage("Перевести $amount ₽ на номер $phone?")
            .setPositiveButton("Перевести") { _, _ ->
                Toast.makeText(this, "Перевод успешно выполнен!", Toast.LENGTH_LONG).show()
                finish()
            }
            .setNegativeButton("Отмена", null)
            .create()
        dialog.show()
    }
}