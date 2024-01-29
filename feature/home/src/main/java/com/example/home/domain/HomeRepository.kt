package com.example.home.domain

import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getToolsGroupsFlow(): Flow<ToolsGroupLoadResult>
}