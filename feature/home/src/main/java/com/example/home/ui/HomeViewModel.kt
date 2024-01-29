package com.example.home.ui

import androidx.lifecycle.viewModelScope
import com.example.home.domain.HomeFlowWrapper
import com.example.home.domain.HomeInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.anb.core.BaseViewModel

class HomeViewModel(
    private val homeInteractor: HomeInteractor,
    override val flowWrapper: HomeFlowWrapper.Mutable
) : BaseViewModel<HomeUiState>() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            homeInteractor.collectToolsGroup(flowWrapper)
        }
    }
}