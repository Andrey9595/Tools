package ru.anb.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.FlowCollector

abstract class BaseViewModel<T : UiState<*>>(private val flowWrapper: FlowWrapper.Mutable<T>) :
    ViewModel(), FlowWrapper.Collect<T> {

    override suspend fun collect(collector: FlowCollector<T>) {
        flowWrapper.collect(collector)
    }
}