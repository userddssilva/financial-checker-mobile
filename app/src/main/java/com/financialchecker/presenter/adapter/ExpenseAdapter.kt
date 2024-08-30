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

package com.financialchecker.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.financialchecker.R
import com.financialchecker.presenter.model.ExpenseUiModel
import com.financialchecker.presenter.adapter.viewholder.ExpenseViewHolder

class ExpenseAdapter(private val expens: List<ExpenseUiModel>) : Adapter<ExpenseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val expenseView = inflater.inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(expenseView)
    }

    override fun getItemCount(): Int {
        return expens.size
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val value = "R$ ${expens[position].value}".replace(".", ",")
        val isPaid = if (expens[position].isPaid) "Paid" else "Unpaid"

        holder.value.text = value
        holder.isPaid.text = isPaid

        holder.category.text = expens[position].category
        holder.description.text = expens[position].description
        holder.category.text = expens[position].description
        holder.date.text = expens[position].date
    }
}