package com.example.home.ui.model

import com.example.adapterdelegates.ListItem

data class ToolsGroupModel(
    val id: Long = 0,
    val imageUrl: String= "",
    val groupName: String= ""
) : ListItem {

    override fun areItemTheSame(other: ListItem): Boolean {
        if (other !is ToolsGroupModel) return false
        return id == other.id
    }

    override fun areContentTheSame(other: ListItem): Boolean {
        if (other !is ToolsGroupModel) return false
        return this == other
    }
}
