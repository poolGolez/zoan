package com.example.zoan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val createLoanNavButton = view.findViewById<Button>(R.id.createLoanNavButton)
        createLoanNavButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_createLoanFragment)
        }

        // Inflate the layout for this fragment
        return view
    }

}
