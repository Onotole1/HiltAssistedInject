package com.example.assistedinjectsample

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle

private const val ID_KEY = "ID_KEY"

fun BlankFragment.setId(id: Long) {
    arguments = (arguments ?: Bundle()).apply { putLong(ID_KEY, id) }
}

val SavedStateHandle.id: Long
    get() = get(ID_KEY) ?: 0
