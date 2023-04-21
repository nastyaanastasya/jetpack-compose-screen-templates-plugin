package com.nastyaanastasya.jetpackcompose.ui.plugin.features.login

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.login.injection.LoginViewModelFactory

class LoginAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val dependencies = ProjectDependencies(e.project)
        val directory = e.getData(CommonDataKeys.PSI_ELEMENT) as PsiDirectory
        val viewModel = LoginViewModelFactory.create(directory, dependencies)
        LoginDialog(viewModel).show()
    }
}
