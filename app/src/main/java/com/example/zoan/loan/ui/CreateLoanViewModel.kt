package com.example.zoan.loan.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateLoanViewModel : ViewModel() {

    val loanAmount = MutableLiveData<Double>()

    val monthsNumber = MutableLiveData<Int>()

    val interest = MutableLiveData<Double>()

    init {
        loanAmount.value = 2500.0
        monthsNumber.value = 1
        interest.value = 0.12
    }

    val payment: Double
        get() {
            val totalInterest: Double = interest.value?.times(monthsNumber?.value ?: 0) ?: 0.00
            val totalReceivable: Double = (loanAmount.value?.times(1.00 + totalInterest)) ?: 0.00
            val gives = monthsNumber.value?.times(2) ?: 1

            return totalReceivable / gives
        }
}