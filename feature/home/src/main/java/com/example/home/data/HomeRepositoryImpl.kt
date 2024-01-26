package com.example.home.data

import com.example.cloudservice.CloudService
import com.example.cloudstorage.CloudStorage
import com.example.home.data.model.ToolsGroupDataModel
import com.example.home.domain.HomeRepository
import com.example.home.domain.ToolsGroupLoadResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class HomeRepositoryImpl(
    private val cloudStorage: CloudStorage,
    private val cloudService: CloudService
) : HomeRepository {
    override fun getToolsGroupsFlow(): Flow<ToolsGroupLoadResult> {
        return cloudService.subscribeToListOf(ToolsGroupDataModel::class.java, "groups")
            .map { list -> ToolsGroupLoadResult.Success(list.map { it.mapToUi(cloudStorage) }) }
            .catch { ToolsGroupLoadResult.Error(it.message?: " ") }
    }
}