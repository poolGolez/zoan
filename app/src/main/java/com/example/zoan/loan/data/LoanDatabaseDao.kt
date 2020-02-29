package com.example.zoan.loan.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface LoanDatabaseDao {

    @Insert
    fun insert(loan: Loan)
}