package ru.anb.core

import androidx.viewbinding.ViewBinding

interface UiState<B: ViewBinding> {

    fun update(binding: B)
}