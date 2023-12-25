package ru.anb.core

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow

interface FlowWrapper {

    interface Post<T : Any> {
        fun post(item: T)
    }

    interface Collect<T : Any> {
        suspend fun collect(collector: FlowCollector<T>)
    }

    interface Mutable<T : Any> : Post<T>, Collect<T>

    abstract class Abstract<T : Any>(private val flow: MutableStateFlow<T>) :
        Mutable<T> {

        override fun post(item: T) {
            flow.value = item
        }

        override suspend fun collect(collector: FlowCollector<T>) {
            flow.collect(collector)
        }
    }

    abstract class Base<T : Any>(initial: T) : Abstract<T>(MutableStateFlow(initial))
}