package com.nastyaanastasya.jetpackcompose.ui.plugin.features.registration

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegistrationDialog(
        private val viewModel: RegistrationViewModel
): BaseDialog() {

    init {
        init()
        viewModel.successFlow
                .onEach { close(0) }
                .launchIn(dialogScope)
    }

    override fun createPanel(): DialogPanel {
        return panel {
            row { label("Create Jetpack Compose Registration Screen") }

            row { checkBox("Use OutlinedTextField instead of TextField", viewModel::useOutlinedTextField) }
            row { checkBox("Set toggle password visibility icon", viewModel::useTrailingIcon) }
            row { checkBox("Add 'Already registered? Sign In' link text", viewModel::useAlreadyRegisteredText) }

            noteRow("Creates a login screen template file 'RegistrationScreen.kt'")
        }
    }

    override fun doOKAction() {
        panel.apply()
        viewModel.onOkButtonClick()
    }
}