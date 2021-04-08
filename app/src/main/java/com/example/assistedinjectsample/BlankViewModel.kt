package com.example.assistedinjectsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class BlankViewModel @AssistedInject constructor(
    @Assisted val params: MyInitParams
) : ViewModel() {
    // TODO: Implement the ViewModel

    @AssistedFactory
    interface ViewModelAssistedFactory {
        fun create(initParams: MyInitParams): BlankViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: ViewModelAssistedFactory,
            initParams: MyInitParams
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(initParams) as T
            }
        }
    }
}
