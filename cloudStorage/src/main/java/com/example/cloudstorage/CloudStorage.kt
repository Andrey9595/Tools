package com.example.cloudstorage

import android.net.Uri

interface CloudStorage {

    suspend fun getDownloadUrl(fileReference: String): Uri

}