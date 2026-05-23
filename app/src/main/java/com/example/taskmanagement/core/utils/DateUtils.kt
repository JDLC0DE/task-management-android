package com.example.taskmanagement.core.utils

import java.time.LocalDate
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateUtils {
    fun formatDueDate(isoDate: String): String {
        return try {
            val date = ZonedDateTime.parse(isoDate).toLocalDate()
            val today = LocalDate.now()

            if (date == today) {
                "TODAY"
            } else {
                val formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy", Locale.ENGLISH)
                date.format(formatter).uppercase()
            }
        } catch (e: Exception) {
            isoDate
        }
    }
}