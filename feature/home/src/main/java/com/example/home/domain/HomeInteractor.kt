package com.example.home.domain

interface HomeInteractor {

    suspend fun collectToolsGroup(homeFlowWrapper: HomeFlowWrapper.Post)

    class Base(private val homeRepository: HomeRepository) : HomeInteractor {

        override suspend fun collectToolsGroup(homeFlowWrapper: HomeFlowWrapper.Post) {
            return homeRepository.getToolsGroupsFlow().collect() {
                it.handle(homeFlowWrapper)
            }
        }
    }
}