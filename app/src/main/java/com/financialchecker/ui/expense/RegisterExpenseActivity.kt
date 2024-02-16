package com.financialchecker.ui.expense

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.financialchecker.MainActivity
import com.financialchecker.R
import com.financialchecker.databinding.ActivityRegisterExpenseBinding

class RegisterExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Create expense"

        val statusItems = resources.getStringArray(R.array.expense_status)
        val essentialItems = resources.getStringArray(R.array.expense_type)

        val statusItemsAdapter = ArrayAdapter(applicationContext, R.layout.item_expense_status, statusItems)
        val essentialItemsAdapter = ArrayAdapter(applicationContext, R.layout.item_expense_status, essentialItems)

        (binding.atvExpenseStatus as? AutoCompleteTextView)?.setAdapter(statusItemsAdapter)
        (binding.atvExpenseEssential as? AutoCompleteTextView)?.setAdapter(essentialItemsAdapter)

        binding.btnAddExpense.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}