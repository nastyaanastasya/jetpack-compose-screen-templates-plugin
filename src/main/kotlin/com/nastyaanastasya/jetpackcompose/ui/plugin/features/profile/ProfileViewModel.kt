package com.nastyaanastasya.jetpackcompose.ui.plugin.features.profile

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseViewModel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.PropertyKeys
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.TemplateGenerator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
        private val directory: PsiDirectory,
        private val generator: TemplateGenerator,
        private val editorManager: FileEditorManager,
) : BaseViewModel() {

    var useArrowBackNavigationIcon = false
    var useMenuNavigationIcon = true
    var useOptionsMenuIcon = false

    val successFlow = MutableSharedFlow<Unit>()

    fun onOkButtonClick() {
        val properties = mutableMapOf<String, Any>(
                PropertyKeys.UseArrowBackNavigationIcon to useArrowBackNavigationIcon,
                PropertyKeys.UseMenuNavigationIcon to useMenuNavigationIcon,
                PropertyKeys.UseTopAppBarOptionsMenuIcon to useOptionsMenuIcon
        )
        val file = generator.generateKt(
                "ProfileScreen",
                "ProfileScreen",
                directory,
                properties
        )

        editorManager.openFile(file.virtualFile, true)
        scope.launch {
            successFlow.emit(Unit)
        }
    }
}