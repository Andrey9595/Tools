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
import com.example.home.ui.model.ToolsGroupModel
import com.google.firebase.storage.FirebaseStorage

class ToolsGroupDelegate : DelegateAdapter<ToolsGroupModel, ToolsGroupViewHolder>() {
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
    DelegateViewHolder<ToolsGroupModel>(binding) {
    override fun bind(item: ToolsGroupModel) {
        binding.text.text = item.groupName

        FirebaseStorage.getInstance().getReferenceFromUrl("gs://tools-294e4.appspot.com")
            .child(item.imageUrl).downloadUrl.addOnSuccessListener {
            Glide.with(binding.image)
                .load(it)
                .transform(
                    CenterCrop(), RoundedCorners(10)
                )
                .into(binding.image)
        }
    }
}