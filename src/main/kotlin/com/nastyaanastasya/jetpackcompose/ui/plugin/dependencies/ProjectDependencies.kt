package com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.nastyaanastasya.jetpackcompose.ui.plugin.core.TemplateGenerator

class ProjectDependencies(
    private val project: Project?
) {
    val generator = TemplateGenerator(project!!)
    val editor: FileEditorManager = FileEditorManager.getInstance(project!!)
    val properties: PropertiesComponent = PropertiesComponent.getInstance()
}

