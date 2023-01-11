package com.nexus.notekeeper.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Long): String {
    val date = Date(time)
    return SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
        .format(date)
}