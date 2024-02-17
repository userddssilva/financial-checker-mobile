package com.financialchecker.ui.category

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.financialchecker.R

class ExpenseCategoryViewHolder(expenseViewItem: View) : ViewHolder(expenseViewItem) {
    var category: TextView = expenseViewItem.findViewById(R.id.tv_expense_category)
}
