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

        val expenseCategoryArray = resources.getStringArray(R.array.expense_category)

        val expenseCategoryItems = ArrayAdapter(applicationContext, R.layout.item_expense_status, expenseCategoryArray)

        (binding.atvExpenseCategory as? AutoCompleteTextView)?.setAdapter(expenseCategoryItems)

        binding.btnAddExpense.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}