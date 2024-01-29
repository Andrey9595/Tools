package com.example.home.data.model

import com.example.cloudstorage.CloudStorage
import com.example.home.ui.model.ToolsGroupUiModel

data class ToolsGroupDataModel(
    val id: Long = 0,
    val imageUrl: String = "",
    val groupName: String = ""
) {
    suspend fun mapToUi(cloudStorage: CloudStorage): ToolsGroupUiModel {
        return ToolsGroupUiModel(
            id = id,
            groupName = groupName,
            imageUrl = cloudStorage.getDownloadUrl(imageUrl)
        )
    }
}
