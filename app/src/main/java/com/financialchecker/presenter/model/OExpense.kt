package com.financialchecker.presenter.model

object OExpense {
    var description: String? = null
    var date: String? = null
    var value: String? = null
    var category: String? = null
    var isPaid: Boolean? = null
    var isEssential: Boolean? = null

    fun isEmpty(): Boolean {
        return (description == null && date == null && category == null && isPaid == null && isEssential == null)
    }

    fun resetInstance() {
        description = null
        date = null
        value = null
        category = null
        isPaid = null
        isEssential = null
    }

    fun isSetProperties(): Boolean {
        return !(description?.isEmpty() == true && date?.isEmpty() == true && value?.isEmpty() == true &&
                category?.isEmpty() == true && isPaid == false && isEssential == false)
    }

    override fun toString(): String {
        val expense = "" +
                "\nDescription: $description\n" +
                "\nDate: $date\n" +
                "\nValue: $value\n" +
                "\nCategory: $category\n" +
                "\nIsPaid: $isPaid\n" +
                "\nIsEssential: $isEssential\n"
        return expense
    }
}