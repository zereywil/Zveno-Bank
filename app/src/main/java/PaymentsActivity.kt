package com.example.zveno_bank

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class PaymentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        findViewById<ImageView>(R.id.back_button).setOnClickListener {
            finish()
        }

        val utilitiesCard = findViewById<MaterialCardView>(R.id.pay_utilities)
        val mobileCard = findViewById<MaterialCardView>(R.id.pay_mobile)
        val internetCard = findViewById<MaterialCardView>(R.id.pay_internet)
        val tvCard = findViewById<MaterialCardView>(R.id.pay_tv)
        val taxesCard = findViewById<MaterialCardView>(R.id.pay_taxes)
        val finesCard = findViewById<MaterialCardView>(R.id.pay_fines)

        utilitiesCard.setOnClickListener { showPaymentDialog("Коммунальные услуги") }
        mobileCard.setOnClickListener { showPaymentDialog("Мобильная связь") }
        internetCard.setOnClickListener { showPaymentDialog("Интернет") }
        tvCard.setOnClickListener { showPaymentDialog("ТВ") }
        taxesCard.setOnClickListener { showPaymentDialog("Налоги") }
        finesCard.setOnClickListener { showPaymentDialog("Штрафы") }
    }

    private fun showPaymentDialog(service: String) {
        val input = EditText(this)
        input.hint = "Введите сумму"
        input.inputType = android.text.InputType.TYPE_CLASS_NUMBER

        AlertDialog.Builder(this)
            .setTitle("Оплата: $service")
            .setView(input)
            .setPositiveButton("Оплатить") { _, _ ->
                val amountText = input.text.toString()
                if (amountText.isNotEmpty()) {
                    val amount = amountText.toDoubleOrNull()
                    if (amount != null && amount > 0) {
                        Toast.makeText(this, "Оплачено $amount ₽ за $service", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Введите корректную сумму", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Введите сумму", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Отмена", null)
            .show()
    }
}