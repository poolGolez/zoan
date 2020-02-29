package com.example.zoan.loan.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Loan(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    var amount: Double = 0.00,

    var monthsToPay: Int = 0
)