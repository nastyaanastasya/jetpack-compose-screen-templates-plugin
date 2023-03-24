package com.nastyaanastasya.jetpackcompose.ui.plugin.features.login

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginDialog(
    private val viewModel: LoginViewModel
): BaseDialog() {

    init {
        init()
        viewModel.successFlow
            .onEach { close(0) }
            .launchIn(dialogScope)
    }

    override fun createPanel(): DialogPanel {
        return panel {
            row { label("Create Jetpack Compose Login Screen") }

            row { checkBox("Use OutlinedTextField instead of TextField", viewModel::useOutlinedTextField) }
            row { checkBox("Set toggle password visibility icon", viewModel::useTrailingIcon) }
            row { checkBox("Create 'Repeat password' field", viewModel::useRepPassword) }
            row { checkBox("Add 'Forget password?' link text", viewModel::useForgetPasswordText) }

            noteRow("Creates a login screen template file 'LoginScreen.kt'")
        }
    }

    override fun doOKAction() {
        panel.apply()
        viewModel.onOkButtonClick()
    }
}
