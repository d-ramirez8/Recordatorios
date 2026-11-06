package com.example.recordatorios.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recordatorios.data.categoryColors
import com.example.recordatorios.data.sampleReminders
import com.example.recordatorios.model.Priority
import com.example.recordatorios.model.Reminder
import com.example.recordatorios.model.label

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemindersScreen(reminders: List<Reminder> = sampleReminders) {
    var onlyHigh by remember { mutableStateOf(false) }
    val shown = if (onlyHigh) {
        reminders.filter { it.priority == Priority.High }
    } else {
        reminders
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Mis recordatorios") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            FilterChip(
                selected = onlyHigh,
                onClick = { onlyHigh = !onlyHigh },
                label = { Text("Solo prioridad alta") },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(shown, key = { it.id }) { reminder ->
                    ReminderCard(reminder)
                }
            }
        }
    }
}

@Composable
fun ReminderCard(reminder: Reminder) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(reminder.title, style = MaterialTheme.typography.titleMedium)

            reminder.description?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(
                            categoryColors[reminder.category] ?: Color.Gray,
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(reminder.category.name, style = MaterialTheme.typography.labelLarge)
            }

            Text("Prioridad: ${reminder.priority.label}")
            Text("Estado: ${reminder.status.label()}")
        }
    }
}