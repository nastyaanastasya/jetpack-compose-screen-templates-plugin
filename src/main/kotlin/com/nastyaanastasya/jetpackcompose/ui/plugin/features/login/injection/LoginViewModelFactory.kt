package com.nastyaanastasya.jetpackcompose.ui.plugin.features.login.injection

import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.login.LoginViewModel

object LoginViewModelFactory {

    fun create(
        psiDirectory: PsiDirectory,
        dependencies: ProjectDependencies
    ): LoginViewModel {
        return LoginViewModel(
            directory = psiDirectory,
            generator = dependencies.generator,
            editorManager = dependencies.editor
        )
    }
}
