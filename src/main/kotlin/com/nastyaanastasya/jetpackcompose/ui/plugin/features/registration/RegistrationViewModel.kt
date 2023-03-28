package com.nastyaanastasya.jetpackcompose.ui.plugin.features.registration

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseViewModel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.PropertyKeys
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.TemplateGenerator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class RegistrationViewModel(
        private val directory: PsiDirectory,
        private val generator: TemplateGenerator,
        private val editorManager: FileEditorManager,
) : BaseViewModel() {

    var useRepPassword = false
    var useAlreadyRegisteredText = false
    var useOutlinedTextField = false
    var useTrailingIcon = false

    val successFlow = MutableSharedFlow<Unit>()

    fun onOkButtonClick() {
        val properties = mutableMapOf<String, Any>(
                PropertyKeys.UseRepPassword to useRepPassword,
                PropertyKeys.UseAlreadyRegisteredText to useAlreadyRegisteredText,
                PropertyKeys.UseOutlinedTextField to useOutlinedTextField,
                PropertyKeys.UseTrailingIcon to useTrailingIcon
        )
        val file = generator.generateKt(
                "RegistrationScreen",
                "RegistrationScreen",
                directory,
                properties
        )

        editorManager.openFile(file.virtualFile, true)
        scope.launch {
            successFlow.emit(Unit)
        }
    }
}