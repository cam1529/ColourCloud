package com.cooki.colourcloud

data class PaletteModel(
    var id: Int? = null,
    var colours: Array<Long>? = null,
    var tags: Array<String>? = null,
    var liked: Boolean = false,
    var saved: Boolean = false
    )