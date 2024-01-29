package com.example.adapterdelegates

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class DelegateViewHolder<in M : ListItem>(
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    
    abstract fun bind(item: M)
    
    fun bind(payload: Payload<ViewBinding>) {
        payload.bindPayload(binding)
    }
}