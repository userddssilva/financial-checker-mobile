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

package com.financialchecker.model.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.financialchecker.R
import com.financialchecker.model.data.Expense
import com.financialchecker.ui.expense.ExpenseViewHolder

class ExpenseAdapter(private val expenses: List<Expense>) : Adapter<ExpenseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val expenseView = inflater.inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(expenseView)
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.description.text = expenses[position].description
        holder.category.text = expenses[position].description
        holder.date.text = expenses[position].date
        holder.value.text = "R$ ${expenses[position].value}".replace(".", ",")
        holder.category.text = expenses[position].category.name
    holder.isPaid.text = if (expenses[position].isPaid) "Paid" else "Unpaid"
    }
}