package com.example.zoan.loan.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zoan.loan.data.LoanDatabaseDao
import com.example.zoan.loan.data.ZoanDatabase

class LoanViewModelFactory(
    private val loanDao: LoanDatabaseDao?,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CreateLoanViewModel::class.java)) {
            return CreateLoanViewModel(loanDao, application) as T
        }
        throw IllegalArgumentException("Unknown view model class $modelClass")
    }
}