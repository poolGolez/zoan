package com.example.zoan.loan.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.zoan.R
import kotlinx.android.synthetic.main.fragment_create_loan.*

/**
 * A simple [Fragment] subclass.
 */
class CreateLoanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_loan, container, false)

        val application = requireNotNull(this.activity).application
//        val database = ZoanDatabase.getInstance(application).loanDatabaseDao
        val viewModelFactory = LoanViewModelFactory(null, application)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CreateLoanViewModel::class.java)

        initializeLoanAmountInput(view, viewModel)
        initializeMonthNumber(view, viewModel)
        observePayment(viewModel)

        return view
    }

    private fun initializeLoanAmountInput(view: View, viewModel: CreateLoanViewModel) {
        val loanAmountInput = view.findViewById<EditText>(R.id.loanAmountInput)
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

    private fun initializeMonthNumber(view: View, viewModel: CreateLoanViewModel) {
        val monthNumberInput = view.findViewById<EditText>(R.id.monthNumberInput)
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

    private fun observePayment(viewModel: CreateLoanViewModel) {
        viewModel.payment.observe(viewLifecycleOwner, Observer { newPayment ->
            paymentDisplay.setText("%,.2f".format(newPayment))
        })
    }
}
