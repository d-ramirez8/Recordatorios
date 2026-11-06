package com.example.recordatorios.model

data class Reminder(
    val id: Int,
    val title: String,
    val category: Category,
    val priority: Priority,
    val status: ReminderStatus,
    val description: String? = null,
    val dueDate: String? = null,
    val location: String? = null
)