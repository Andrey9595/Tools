package ru.anb.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.FlowCollector

abstract class BaseViewModel<T : UiState<*>>() :
    ViewModel(), FlowWrapper.Collect<T> {

    protected abstract val flowWrapper: FlowWrapper.Mutable<T>
    override suspend fun collect(collector: FlowCollector<T>) {
        flowWrapper.collect(collector)
    }
}