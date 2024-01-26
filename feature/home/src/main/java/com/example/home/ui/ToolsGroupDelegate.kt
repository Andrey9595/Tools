package com.example.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.adapterdelegates.DelegateAdapter
import com.example.adapterdelegates.DelegateViewHolder
import com.example.home.databinding.ToolsGroupItemBinding
import com.example.home.ui.model.ToolsGroupUiModel

class ToolsGroupDelegate : DelegateAdapter<ToolsGroupUiModel, ToolsGroupViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ToolsGroupViewHolder(
            ToolsGroupItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class ToolsGroupViewHolder(private val binding: ToolsGroupItemBinding) :
    DelegateViewHolder<ToolsGroupUiModel>(binding) {
    override fun bind(item: ToolsGroupUiModel) {
        binding.text.text = item.groupName


        Glide.with(binding.image)
            .load(item.imageUrl)
            .transform(
                CenterCrop(), RoundedCorners(10)
            )
            .into(binding.image)
    }
}