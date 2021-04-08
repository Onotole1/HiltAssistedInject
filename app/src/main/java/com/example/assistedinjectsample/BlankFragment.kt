package com.example.assistedinjectsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BlankFragment : Fragment() {

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun newInstance(id: Long) = BlankFragment().apply {
            arguments = bundleOf(ID_KEY to id)
        }
    }

    @Inject
    lateinit var myViewModelAssistedFactory: BlankViewModel.ViewModelAssistedFactory

    private val viewModel: BlankViewModel by viewModels {
        BlankViewModel.provideFactory(
            myViewModelAssistedFactory,
            requireArguments()
                .getLong(ID_KEY)
                .let(::MyInitParams)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.blank_fragment, container, false).apply {
            findViewById<TextView>(R.id.idView).text = viewModel.params.id.toString()
        }
}
