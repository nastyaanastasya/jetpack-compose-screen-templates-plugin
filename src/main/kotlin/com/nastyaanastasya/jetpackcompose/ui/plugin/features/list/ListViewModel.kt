package com.nastyaanastasya.jetpackcompose.ui.plugin.features.list

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.psi.PsiDirectory
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.BaseViewModel
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.PropertyKeys
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.TemplateGenerator
import com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.domain.ListFeaturePropertiesRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ListViewModel(
        private val directory: PsiDirectory,
        private val generator: TemplateGenerator,
        private val repository: ListFeaturePropertiesRepository,
        private val editorManager: FileEditorManager,
) : BaseViewModel() {

    var listName: String = ""
        get() = field.capitalize()

    var useOneLineListItem: Boolean
        get() = repository.get().useOneLineListItem
        set(value) = repository.put(repository.get().copy(useOneLineListItem = value))

    var useTwoLinesListItem: Boolean
        get() = repository.get().useTwoLinesListItem
        set(value) = repository.put(repository.get().copy(useTwoLinesListItem = value))

    var useThreeLinesListItem: Boolean
        get() = repository.get().useThreeLinesListItem
        set(value) = repository.put(repository.get().copy(useThreeLinesListItem = value))

    var useListItemWithImage: Boolean
        get() = repository.get().useListItemWithImage
        set(value) = repository.put(repository.get().copy(useListItemWithImage = value))

    var useScrollToTopButton: Boolean
        get() = repository.get().useScrollToTopButton
        set(value) = repository.put(repository.get().copy(useScrollToTopButton = value))

    val successFlow = MutableSharedFlow<Unit>()

    fun onOkButtonClick() {
        val properties = mutableMapOf<String, Any>(
                PropertyKeys.ListName to listName,
                PropertyKeys.UseOneLineListItem to useOneLineListItem,
                PropertyKeys.UseTwoLineListItem to useTwoLinesListItem,
                PropertyKeys.UseThreeLineListItem to useThreeLinesListItem,
                PropertyKeys.UseListItemWithImage to useListItemWithImage,
                PropertyKeys.UseScrollToTopButton to useScrollToTopButton
        )
        val file = generator.generateKt(
                "ListScreen",
                "${listName}ListScreen",
                directory,
                properties
        )

        editorManager.openFile(file.virtualFile, true)
        scope.launch {
            successFlow.emit(Unit)
        }
    }
}