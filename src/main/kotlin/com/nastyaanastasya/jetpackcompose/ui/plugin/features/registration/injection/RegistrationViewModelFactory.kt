package com.nastyaanastasya.jetpackcompose.ui.plugin.features.registration.injection

import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.registration.RegistrationViewModel

object RegistrationViewModelFactory {

    fun create(
            psiDirectory: PsiDirectory,
            dependencies: ProjectDependencies
    ): RegistrationViewModel {
        return RegistrationViewModel(
                directory = psiDirectory,
                generator = dependencies.generator,
                editorManager = dependencies.editor
        )
    }
}