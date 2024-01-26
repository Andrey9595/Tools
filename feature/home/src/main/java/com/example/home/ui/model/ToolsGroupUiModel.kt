package com.example.home.ui.model

import android.net.Uri
import com.example.adapterdelegates.ListItem

data class ToolsGroupUiModel(
    val id: Long,
    val imageUrl: Uri,
    val groupName: String
) : ListItem {

    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is ToolsGroupUiModel) return false
        return id == other.id
    }

    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is ToolsGroupUiModel) return false
        return this == other
    }
}
