package com.nastyaanastasya.jetpackcompose.ui.plugin.core.persistence

interface PreferenceDataSource {
    fun put(key: String, value: Boolean)
    fun get(key: String) : Boolean
}