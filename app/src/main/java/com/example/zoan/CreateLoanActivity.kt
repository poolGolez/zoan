package com.example.zoan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_create_loan.*

class CreateLoanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_loan)

        val paymentListener = PaymentTextWatcher()
        loanAmountInput.addTextChangedListener(paymentListener)
        monthNumberInput.addTextChangedListener(paymentListener)
        loanAmountInput.setText(loanAmountInput.text)
    }

    fun computeInstallmentPayment(loanAmount: Double, monthsNum: Int, interest: Double): Double {
        val totalInterest = interest * monthsNum
        val totalReceivable = (loanAmount * (1 + totalInterest))
        val gives = monthsNum * 2

        return totalReceivable / gives
    }

    open inner class PaymentTextWatcher : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val amountTextInput = loanAmountInput.text.toString()
            val monthsNumTextInput = monthNumberInput.text.toString()

            var payment = 0.00
            if (amountTextInput != "" && monthsNumTextInput != "") {
                val amount = amountTextInput.toDouble()
                val monthsNum = monthsNumTextInput.toInt()
                payment = computeInstallmentPayment(amount, monthsNum, 0.12)
            }
            paymentDisplay.setText("%,.2f".format(payment))
        }
    }
}
