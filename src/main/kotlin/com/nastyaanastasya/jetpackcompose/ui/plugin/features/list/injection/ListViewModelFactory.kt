package com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.injection

import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.ListViewModel

object ListViewModelFactory {

    fun create(
            psiDirectory: PsiDirectory,
            dependencies: ProjectDependencies
    ): ListViewModel {
        return ListViewModel(
                directory = psiDirectory,
                generator = dependencies.generator,
                repository = ListFeaturePropertiesRepositoryFactory.create(dependencies),
                editorManager = dependencies.editor
        )
    }
}