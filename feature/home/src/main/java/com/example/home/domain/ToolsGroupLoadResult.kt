package com.example.home.domain

import com.example.home.ui.HomeUiState
import com.example.home.ui.model.ToolsGroupUiModel

interface ToolsGroupLoadResult {

    fun handle(homeFlowWrapper: HomeFlowWrapper.Post)

    class Success(private val data: List<ToolsGroupUiModel>) : ToolsGroupLoadResult {
        override fun handle(homeFlowWrapper: HomeFlowWrapper.Post) {
            homeFlowWrapper.post(HomeUiState.Success(data))
        }
    }

    class Error(private val message: String) : ToolsGroupLoadResult {
        override fun handle(homeFlowWrapper: HomeFlowWrapper.Post) {
            homeFlowWrapper.post(HomeUiState.Error(message))
        }
    }
}