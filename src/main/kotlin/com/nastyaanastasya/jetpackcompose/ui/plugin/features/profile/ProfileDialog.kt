package com.nastyaanastasya.jetpackcompose.ui.plugin.features.profile

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProfileDialog(
        private val viewModel: ProfileViewModel
): BaseDialog() {

    init {
        init()
        viewModel.successFlow
                .onEach { close(0) }
                .launchIn(dialogScope)
    }

    override fun createPanel(): DialogPanel {
        return panel {
            row { label("Create Jetpack Compose Profile Screen") }

            row { label("") }
            row { label("Which navigation icon do you want to use?") }
            buttonGroup {
                row {
                    radioButton("Set 'Menu' navigation icon", viewModel::useMenuNavigationIcon)
                }
                row {
                    radioButton("Set 'Arrow back' navigation icon", viewModel::useArrowBackNavigationIcon)
                }
            }
            row { label("") }

            row { checkBox("Add options menu icon on TopAppBar", viewModel::useOptionsMenuIcon) }

            noteRow("Creates a profile screen template file 'ProfileScreen.kt'")
        }
    }

    override fun doOKAction() {
        panel.apply()
        viewModel.onOkButtonClick()
    }
}