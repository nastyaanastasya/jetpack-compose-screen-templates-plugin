package com.nastyaanastasya.jetpackcompose.ui.plugin.features.list

import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListDialog(
        private val viewModel: ListViewModel
) : BaseDialog() {

    init {
        init()
        viewModel.successFlow
                .onEach { close(0) }
                .launchIn(dialogScope)
    }

    override fun createPanel(): DialogPanel {
        return panel {
            row { label("Create Jetpack Compose List Screen") }

            row { label("Enter prefix for file name '<prefix>ListScreen.kt'") }
            row { textField(viewModel::listName).focused() }
            row { label("") }

            row { label("Which type of list item do you want to use?") }
            buttonGroup {
                row {
                    radioButton("Use one-line list item", viewModel::useOneLineListItem)
                }
                row {
                    radioButton("Use two-line list item", viewModel::useTwoLinesListItem)
                }
                row {
                    radioButton("Use three-line list item", viewModel::useThreeLinesListItem)
                }
            }
            row { label("") }

            row { checkBox("Use list item with image", viewModel::useListItemWithImage) }
            row { checkBox("Set scroll-to-top button", viewModel::useScrollToTopButton) }

            noteRow("Creates a list screen template file '<prefix>ListScreen.kt'")
        }
    }

    override fun doOKAction() {
        panel.apply()
        viewModel.onOkButtonClick()
    }
}