package com.example.assistedinjectsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlankFragment : Fragment() {

    companion object {
        fun newInstance(id: Long) = BlankFragment().apply { setId(id) }
    }

    private val viewModel: BlankViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.blank_fragment, container, false).apply {
            findViewById<TextView>(R.id.idView).text = viewModel.id.toString()
        }
}
