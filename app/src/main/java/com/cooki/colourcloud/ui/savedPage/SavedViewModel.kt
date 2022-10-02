package com.cooki.colourcloud.ui.savedPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SavedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the Saved page"
    }
    val text: LiveData<String> = _text
}