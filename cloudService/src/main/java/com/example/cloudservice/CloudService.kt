package com.example.cloudservice

import kotlinx.coroutines.flow.Flow

interface CloudService {
    
    suspend fun postWithIdGenerating(obj: Any?, vararg children: String): String
    
    suspend fun <T : Any> getDataSnapshot(clazz: Class<T>, vararg children: String): T
    
    fun post(obj: Any?, vararg children: String)
    
    fun <T : DatabaseListItem> addItemToList(item: T, vararg children: String)
    
    fun <T : DatabaseListItem> subscribe(clazz: Class<T>, vararg children: String): Flow<T>
    
    fun <T : Any> subscribeToListOf(clazz: Class<T>, vararg children: String): Flow<List<T>>
    
}