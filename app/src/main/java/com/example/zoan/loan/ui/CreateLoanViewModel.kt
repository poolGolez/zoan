package com.example.zoan.loan.ui

 import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.zoan.loan.data.Loan
import com.example.zoan.loan.data.LoanDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class CreateLoanViewModel(
    val loanDao: LoanDatabaseDao?,
    application: Application
) : AndroidViewModel(application) {

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

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val loanDao: LoanDatabaseDao

//    init {
//        loanDao = ZoanDatabase.getInstance(application).loanDatabaseDao
//    }


    fun insert(loan: Loan) {
        loanDao!!.insert(loan)
    }

    private fun _computePayment() {
        val totalInterest: Double = interest * monthsNumber
        val totalReceivable: Double = (loanAmount * (1.00 + totalInterest))
        val gives: Int = monthsNumber * 2
        _payment.value = totalReceivable / gives
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
