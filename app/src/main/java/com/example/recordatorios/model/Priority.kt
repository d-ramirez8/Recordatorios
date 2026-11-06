package com.example.recordatorios.model

sealed class Priority(val label: String, val level: Int) {
    data object Low : Priority("Baja", 1)
    data object Medium : Priority("Media", 2)
    data object High : Priority("Alta", 3)
}