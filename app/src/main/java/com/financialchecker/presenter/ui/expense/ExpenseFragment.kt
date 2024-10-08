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

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.financialchecker.R
import com.financialchecker.databinding.FragmentExpenseBinding
import com.financialchecker.presenter.adapter.ExpenseAdapter
import com.financialchecker.presenter.model.ExpenseUiModel
import com.financialchecker.presenter.model.OExpense
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExpenseFragment : Fragment() {

    companion object {
        private val TAG = ExpenseFragment::class.java.simpleName
    }

    private lateinit var expensesRecycleView: RecyclerView
    private lateinit var expenses: ArrayList<ExpenseUiModel>

    private var _binding: FragmentExpenseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = getString(R.string.expense)
        val expenseViewModel =
            ViewModelProvider(this).get(ExpenseViewModel::class.java)

        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val addExpenseButton: FloatingActionButton = binding.floatingActionButton

        addExpenseButton.setOnClickListener {
            val intent = Intent(context, CreateExpenseActivity::class.java)
            startActivity(intent)
        }

        expenses = arrayListOf()
        expensesRecycleView = binding.rcExpenses
        expensesRecycleView.layoutManager = LinearLayoutManager(context)
        expensesRecycleView.adapter = ExpenseAdapter(expenses)

        return root
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, OExpense.toString())
        if (!OExpense.isEmpty() && OExpense.isSetProperties()) {
            OExpense.let {
                val newExpense = ExpenseUiModel(
                    description = it.description ?: "",
                    date = it.date ?: "",
                    value = (it.value ?: 0.0).toString().toDouble(),
                    category = it.category ?: "",
                    isPaid = it.isPaid ?: false,
                    isEssential = it.isEssential ?: false
                )
                expenses.add(newExpense)
                expensesRecycleView.adapter?.notifyDataSetChanged()
            }
            OExpense.resetInstance()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}