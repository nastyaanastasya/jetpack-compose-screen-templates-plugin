package com.nastyaanastasya.jetpackcompose.ui.plugin.features.list.domain

import com.nastyaanastasya.jetpackcompose.ui.plugin.core.persistence.PreferenceDataSource

class ListFeaturePropertiesRepository(
        private val dataSource: PreferenceDataSource
) {

    fun put(properties: ListFeatureProperties) {
        dataSource.put(ScrollToTopButton, properties.useScrollToTopButton)
        dataSource.put(OneLineListItem, properties.useOneLineListItem)
        dataSource.put(TwoLinesListItem, properties.useTwoLinesListItem)
        dataSource.put(ThreeLinesListItem, properties.useThreeLinesListItem)
        dataSource.put(ListItemWithImage, properties.useListItemWithImage)
    }

    fun get(): ListFeatureProperties {
        return ListFeatureProperties(
                useScrollToTopButton = dataSource.get(ScrollToTopButton),
                useOneLineListItem = dataSource.get(OneLineListItem),
                useTwoLinesListItem = dataSource.get(TwoLinesListItem),
                useThreeLinesListItem = dataSource.get(ThreeLinesListItem),
                useListItemWithImage = dataSource.get(ListItemWithImage)
        )
    }

    companion object {
        private const val ScrollToTopButton = "scroll_to_top_button"
        private const val OneLineListItem = "one_line_list_item"
        private const val TwoLinesListItem = "two_lines_list_item"
        private const val ThreeLinesListItem = "three_lines_list_item"
        private const val ListItemWithImage = "list_item_with_image"
    }
}