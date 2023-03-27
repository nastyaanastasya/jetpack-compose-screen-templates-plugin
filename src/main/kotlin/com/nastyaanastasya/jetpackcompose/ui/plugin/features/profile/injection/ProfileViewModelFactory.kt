package com.nastyaanastasya.jetpackcompose.ui.plugin.features.profile.injection

import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.profile.ProfileViewModel

object ProfileViewModelFactory {

    fun create(
            psiDirectory: PsiDirectory,
            dependencies: ProjectDependencies
    ): ProfileViewModel {
        return ProfileViewModel(
                directory = psiDirectory,
                generator = dependencies.generator,
                editorManager = dependencies.editor
        )
    }
}