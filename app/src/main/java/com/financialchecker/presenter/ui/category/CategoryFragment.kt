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

package com.financialchecker.presenter.ui.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.financialchecker.R
import com.financialchecker.databinding.FragmentCategoryBinding
import com.financialchecker.presenter.adapter.ExpenseCategoryAdapter

class CategoryFragment : Fragment() {
    private var _binding: FragmentCategoryBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val stringsCategories = resources.getStringArray(R.array.expense_category)
        val categories = arrayListOf<String>()

        stringsCategories.forEach { name ->
            categories.add(name)
        }

        val categoriesAdapter = ExpenseCategoryAdapter(categories)
        val expenseCategoryRecycleView = binding.rcExpenseCategories

        expenseCategoryRecycleView.layoutManager = LinearLayoutManager(context)
        expenseCategoryRecycleView.adapter = categoriesAdapter

        binding.btnAddCategory.setOnClickListener {
            val intent = Intent(context, CreateCategoryActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}