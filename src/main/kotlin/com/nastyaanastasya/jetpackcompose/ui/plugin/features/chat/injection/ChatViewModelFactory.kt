package com.nastyaanastasya.jetpackcompose.ui.plugin.features.chat.injection

import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.ProjectDependencies
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.chat.ChatViewModel

object ChatViewModelFactory {

    fun create(
            psiDirectory: PsiDirectory,
            dependencies: ProjectDependencies
    ): ChatViewModel {
        return ChatViewModel(
                directory = psiDirectory,
                generator = dependencies.generator,
                editorManager = dependencies.editor
        )
    }
}