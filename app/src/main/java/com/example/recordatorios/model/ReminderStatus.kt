package com.example.recordatorios.model

sealed class ReminderStatus {
    data object Pending : ReminderStatus()
    data object InProgress : ReminderStatus()
    data object Completed : ReminderStatus()
    data class Overdue(val daysLate: Int) : ReminderStatus()
}

fun ReminderStatus.label(): String = when (this) {
    ReminderStatus.Pending -> "Pendiente"
    ReminderStatus.InProgress -> "En progreso"
    ReminderStatus.Completed -> "Completado"
    is ReminderStatus.Overdue -> "Vencido ($daysLate días)"
}