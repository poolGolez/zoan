package com.example.zoan.loan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zoan.R

class CreateLoanActivity : AppCompatActivity() {

    private lateinit var viewModel: CreateLoanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_loan)
    }
}
