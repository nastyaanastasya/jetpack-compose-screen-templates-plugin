package com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.injection

import com.nastyaanastasya.jetpackcompose.ui.plugin.core.persistence.PreferenceDataSourceImpl
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.domain.ListFeaturePropertiesRepository

object ListFeaturePropertiesRepositoryFactory {

    fun create(
            dependencies: ProjectDependencies
    ): ListFeaturePropertiesRepository {
        return ListFeaturePropertiesRepository(
                dataSource = PreferenceDataSourceImpl(
                        component = dependencies.properties
                )
        )
    }
}