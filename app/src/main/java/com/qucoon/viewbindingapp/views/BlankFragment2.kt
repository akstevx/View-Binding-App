package com.qucoon.viewbindingapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.qucoon.viewbindingapp.R
import com.qucoon.viewbindingapp.base.BaseFragment
import com.qucoon.viewbindingapp.base.observeChange
import com.qucoon.viewbindingapp.databinding.FragmentBlank2Binding
import com.qucoon.viewbindingapp.viewmodel.BindingViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class BlankFragment2 : BaseFragment() {
    private val viewModel: BindingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentBlank2Binding = FragmentBlank2Binding.inflate(inflater)
        binding.bindingViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.lengthOfThoughtsListener.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })

//        viewModel.clearListener.observe(viewLifecycleOwner, Observer {
//            Toast.makeText(context, "Cleared!", Toast.LENGTH_LONG).show()
//        })

        return binding.root
    }

}