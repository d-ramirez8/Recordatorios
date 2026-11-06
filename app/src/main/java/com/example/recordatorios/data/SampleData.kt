package com.example.recordatorios.data

import androidx.compose.ui.graphics.Color
import com.example.recordatorios.model.Category
import com.example.recordatorios.model.Priority
import com.example.recordatorios.model.Reminder
import com.example.recordatorios.model.ReminderStatus

// Set: evita categorías repetidas
val categories: Set<Category> = setOf(
    Category(1, "Trabajo"),
    Category(2, "Estudio"),
    Category(3, "Hogar"),
    Category(4, "Salud")
)

private fun cat(id: Int): Category = categories.first { it.id == id }

// Map: asocia cada categoría con un color
val categoryColors: Map<Category, Color> = mapOf(
    cat(1) to Color(0xFF1E88E5),
    cat(2) to Color(0xFF8E24AA),
    cat(3) to Color(0xFF43A047),
    cat(4) to Color(0xFFE53935)
)

// List: recordatorios simulados
val sampleReminders: List<Reminder> = listOf(
    Reminder(
        id = 1,
        title = "Entregar informe mensual",
        category = cat(1),
        priority = Priority.High,
        status = ReminderStatus.Pending,
        description = "Enviar al área de gestión",
        dueDate = "10/11/2026"
    ),
    Reminder(
        id = 2,
        title = "Estudiar Kotlin",
        category = cat(2),
        priority = Priority.Medium,
        status = ReminderStatus.InProgress
    ),
    Reminder(
        id = 3,
        title = "Comprar productos de limpieza",
        category = cat(3),
        priority = Priority.Low,
        status = ReminderStatus.Completed,
        location = "Supermercado"
    ),
    Reminder(
        id = 4,
        title = "Control médico",
        category = cat(4),
        priority = Priority.High,
        status = ReminderStatus.Overdue(2),
        dueDate = "03/11/2026",
        location = "Clínica central"
    ),
    Reminder(
        id = 5,
        title = "Reunión de equipo",
        category = cat(1),
        priority = Priority.Medium,
        status = ReminderStatus.Pending
    )
)

// Filtros por prioridad y por estado
val highPriorityReminders: List<Reminder> =
    sampleReminders.filter { it.priority == Priority.High }

val pendingReminders: List<Reminder> =
    sampleReminders.filter { it.status == ReminderStatus.Pending }