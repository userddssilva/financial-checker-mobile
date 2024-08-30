/*
 * MIT License
 *
 * Copyright (c) 2024 Financial Checker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.financialchecker.presenter.ui.expense

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.financialchecker.R
import com.financialchecker.databinding.ActivityCreateExpenseBinding
import com.financialchecker.presenter.model.OExpense
import com.financialchecker.presenter.ui.category.CreateCategoryActivity

class CreateExpenseActivity : AppCompatActivity() {

    companion object{
        private val TAG: String = CreateCategoryActivity::class.java.simpleName
    }

    private lateinit var binding: ActivityCreateExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Create expense"

        val expenseCategoryArray = resources.getStringArray(R.array.expense_category)

        val expenseCategoryItems =
            ArrayAdapter(applicationContext, R.layout.item_tv_auto_complete, expenseCategoryArray)

        (binding.atvExpenseCategory as? AutoCompleteTextView)?.setAdapter(expenseCategoryItems)

        binding.btnAddExpense.setOnClickListener {
            OExpense.let { obj ->
                binding.let { bin ->
                    obj.description = bin.tiDescription.text.toString()
                    obj.date = bin.tiDate.text.toString()
                    obj.value = bin.tiValue.text.toString()
                    obj.category = bin.tiCategory.editText?.text.toString()
                    obj.isPaid = bin.swtPaid.isActivated
                    obj.isEssential = bin.swtIsEssential.isActivated
                }
            }
            Log.d(TAG, OExpense.toString())
            onBackPressedDispatcher.onBackPressed()
        }
    }
}