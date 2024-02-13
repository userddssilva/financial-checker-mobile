package com.financialchecker.ui.expense

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.financialchecker.R
import com.financialchecker.databinding.ActivityRegisterExpenseBinding

class RegisterExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Create expense"

        val items = resources.getStringArray(R.array.expense_status)
        val adapter = ArrayAdapter(applicationContext, R.layout.item_expense_status, items)

        (binding.atvExpenseStatus as? AutoCompleteTextView)?.setAdapter(adapter)
    }
}