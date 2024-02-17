package com.financialchecker.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.financialchecker.R

class ExpenseCategoryAdapter(private val expenseCategoryItems: List<ExpenseCategory>) : Adapter<ExpenseCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseCategoryViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val expenseCategoryView = inflater.inflate(R.layout.item_expense_category, parent, false)
        return ExpenseCategoryViewHolder(expenseCategoryView)
    }

    override fun getItemCount(): Int {
        return expenseCategoryItems.size
    }

    override fun onBindViewHolder(holder: ExpenseCategoryViewHolder, position: Int) {
        holder.category.text = expenseCategoryItems[position].name
    }
}
