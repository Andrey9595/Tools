package com.example.adapterdelegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class DelegateAdapter<M : ListItem, VH : DelegateViewHolder<M>> {

    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    inline fun <reified M> viewType(): Int = M::class.hashCode()

    fun bindViewHolder(item: M, viewHolder: VH) {
        viewHolder.bind(item)
    }

    fun bindViewHolder(viewHolder: VH, payload: Payload<ViewBinding>) {
        viewHolder.bind(payload)
    }
}