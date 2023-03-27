package com.nastyaanastasya.jetpackcompose.ui.plugin.core.persistence

import com.intellij.ide.util.PropertiesComponent

class PreferenceDataSourceImpl(
        private val component: PropertiesComponent
) : PreferenceDataSource {

    override fun put(key: String, value: Boolean) {
        component.setValue(key.projectKey, value)
    }

    override fun get(key: String): Boolean {
        return component.getBoolean(key.projectKey)
    }

    private val String.projectKey: String get() {
        return "com.nastyaanastasya.jetpackcompose.ui.plugin_$this"
    }
}