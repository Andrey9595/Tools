package com.example.home.domain

import com.example.home.ui.HomeUiState
import ru.anb.core.FlowWrapper

interface HomeFlowWrapper {

    interface Post : FlowWrapper.Post<HomeUiState>

    interface Collect : FlowWrapper.Collect<HomeUiState>

    interface Mutable : FlowWrapper.Mutable<HomeUiState>, Post, Collect

    class Base : FlowWrapper.Base<HomeUiState>(HomeUiState.Initial()), Mutable
}