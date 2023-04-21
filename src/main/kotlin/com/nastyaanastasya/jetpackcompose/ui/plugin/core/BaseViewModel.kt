package com.nastyaanastasya.jetpackcompose.ui.plugin.core

import com.nastyaanastasya.jetpackcompose.ui.plugin.dependencies.Dependencies

abstract class BaseViewModel {
    protected val scope = Dependencies.ioScope
}
