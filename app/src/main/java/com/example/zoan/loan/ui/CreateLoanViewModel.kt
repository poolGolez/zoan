package com.example.zoan.loan.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateLoanViewModel : ViewModel() {

    var loanAmount: Double = 2500.0
        set(value: Double) {
            field = value
            _computePayment()
        }

    var monthsNumber: Int = 1
        set(value: Int) {
            field = value
            _computePayment()
        }

    val interest: Double = 0.12

    private val _payment = MutableLiveData<Double>()
    val payment: LiveData<Double>
        get() = _payment


    private fun _computePayment() {
        val totalInterest: Double = interest * monthsNumber
        val totalReceivable: Double = (loanAmount * (1.00 + totalInterest))
        val gives: Int = monthsNumber * 2
        _payment.value = totalReceivable / gives
    }
}
