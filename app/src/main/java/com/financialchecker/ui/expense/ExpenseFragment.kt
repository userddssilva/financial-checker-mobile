package com.financialchecker.ui.expense

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.financialchecker.databinding.FragmentExpenseBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExpenseFragment : Fragment() {

    private var _binding: FragmentExpenseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val expenseViewModel =
            ViewModelProvider(this).get(ExpenseViewModel::class.java)

        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val addExpenseButton: FloatingActionButton = binding.floatingActionButton

        addExpenseButton.setOnClickListener {
            val intent = Intent(context, RegisterExpenseActivity::class.java)
            startActivity(intent)
        }

//        val textView: TextView = binding.textHome
//        expenseViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}