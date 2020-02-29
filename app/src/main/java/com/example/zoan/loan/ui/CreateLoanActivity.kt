package com.example.zoan.loan.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.zoan.R
import kotlinx.android.synthetic.main.activity_create_loan.*

class CreateLoanActivity : AppCompatActivity() {

    private lateinit var viewModel: CreateLoanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_loan)

        viewModel = ViewModelProviders.of(this).get(CreateLoanViewModel::class.java)

        initializeLoanAmountInput()
        initializeMonthNumber()

        viewModel.payment.observe(this, Observer { newPayment ->
            paymentDisplay.setText("%,.2f".format(newPayment))
        })
    }

    private fun initializeLoanAmountInput() {
        loanAmountInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                val loanAmount: Double
                if (text == null || text.toString().trim() == "") {
                    loanAmount = 0.00
                } else {
                    loanAmount = text.toString().toDouble()
                }
                viewModel.loanAmount = loanAmount
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun initializeMonthNumber() {
        monthNumberInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                val monthNumber: Int
                if (text == null || text.toString().trim() == "") {
                    monthNumber = 1
                } else {
                    monthNumber = text.toString().toInt()
                }
                viewModel.monthsNumber = monthNumber
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

}
