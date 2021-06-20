package com.qucoon.viewbindingapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.qucoon.viewbindingapp.base.BaseFragment
import com.qucoon.viewbindingapp.base.observeChange
import com.qucoon.viewbindingapp.databinding.FragmentBlankBinding
import com.qucoon.viewbindingapp.viewmodel.BindingViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class BlankFragment : BaseFragment() {
    private val bindingViewModel: BindingViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        ViewModel -> View -> Layout Resource
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        val binding: FragmentBlankBinding = FragmentBlankBinding.inflate(inflater, container, false)
        val binding = FragmentBlankBinding.inflate(inflater)
        binding.bindingViewModel = bindingViewModel
        binding.lifecycleOwner = viewLifecycleOwner

//        return inflater.inflate(R.layout.fragment_blank, container, false)
        return binding.root
    }

}