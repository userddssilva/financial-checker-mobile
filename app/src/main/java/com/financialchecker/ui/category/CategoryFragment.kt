package com.financialchecker.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.financialchecker.R
import com.financialchecker.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val stringsCategories = resources.getStringArray(R.array.expense_category)
        val categories = arrayListOf<ExpenseCategory>()

        stringsCategories.forEach { name ->
            categories.add(ExpenseCategory(name, true))
        }

        val categoriesAdapter = ExpenseCategoryAdapter(categories)
        val expenseCategoryRecycleView = binding.rcExpenseCategories

        expenseCategoryRecycleView.layoutManager = LinearLayoutManager(context)
        expenseCategoryRecycleView.adapter = categoriesAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}