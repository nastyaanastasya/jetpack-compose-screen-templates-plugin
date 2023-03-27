package com.nastyaanastasya.jetpackcompose.ui.plugin.features.chat

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ChatDialog(
        private val viewModel: ChatViewModel
) : BaseDialog() {

    init {
        init()
        viewModel.successFlow
                .onEach { close(0) }
                .launchIn(dialogScope)
    }

    override fun createPanel(): DialogPanel {
        return panel {
            row { label("Create Jetpack Compose Chat Screen") }

            row { label("") }
            row { label("Choose text field type for message input:") }
            buttonGroup {
                row {
                    radioButton("Use TextField for message input", viewModel::useTextField)
                }
                row {
                    radioButton("Use OutlinedTextField for message input", viewModel::useOutlinedTextField)
                }
            }
            row { label("") }

            row { checkBox("Add search icon on TopAppBar", viewModel::useTopAppBarSearchIcon) }
            row { checkBox("Add options menu icon on TopAppBar", viewModel::useTopAppBarOptionsMenuIcon) }

            noteRow("Creates a chat screen template file 'ChatScreen.kt'")
        }
    }

    override fun doOKAction() {
        panel.apply()
        viewModel.onOkButtonClick()
    }
}