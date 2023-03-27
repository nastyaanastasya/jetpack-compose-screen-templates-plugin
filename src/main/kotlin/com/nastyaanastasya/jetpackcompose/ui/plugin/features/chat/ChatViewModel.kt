package com.nastyaanastasya.jetpackcompose.ui.plugin.features.chat

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseViewModel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.PropertyKeys
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.TemplateGenerator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ChatViewModel(
        private val directory: PsiDirectory,
        private val generator: TemplateGenerator,
        private val editorManager: FileEditorManager,
): BaseViewModel() {

    var useTopAppBarMenuIcon = false
    var useTopAppBarSearchIcon = false
    var useOutlinedTextField = false
    var useTextField = true

    val successFlow = MutableSharedFlow<Unit>()

    fun onOkButtonClick() {
        val properties = mutableMapOf<String, Any>(
                PropertyKeys.UseTopAppBarMenuIcon to useTopAppBarMenuIcon,
                PropertyKeys.UseTopAppBarSearchIcon to useTopAppBarSearchIcon,
                PropertyKeys.UseOutlinedTextField to useOutlinedTextField
        )
        val file = generator.generateKt(
                "ChatScreen",
                "ChatScreen",
                directory,
                properties
        )

        editorManager.openFile(file.virtualFile, true)
        scope.launch {
            successFlow.emit(Unit)
        }
    }
}