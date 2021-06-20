package com.qucoon.viewbindingapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qucoon.viewbindingapp.R
import com.qucoon.viewbindingapp.base.BaseFragment
import com.qucoon.viewbindingapp.base.observeChange
import com.qucoon.viewbindingapp.databinding.FragmentBlank3Binding
import com.qucoon.viewbindingapp.viewmodel.BindingViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel


class BlankFragment3 : BaseFragment() {
    private val viewModel: BindingViewModel by sharedViewModel()
//    private var fragmentBlankBinding: FragmentBlank3Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentBlank3Binding = FragmentBlank3Binding.inflate(inflater)
//        fragmentBlankBinding = binding
        binding.bindingViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.gameListener.observeChange(viewLifecycleOwner){
            viewModel.nameListener.value = "Welcome to first game '$it'"
            mFragmentNavigation.pushFragment(BlankFragment())
        }

        viewModel.moveToNextGameListener.observeChange(viewLifecycleOwner){
            viewModel.clearListener.value = "Welcome to next game '$it'"
            mFragmentNavigation.pushFragment(BlankFragment2())
        }

        viewModel.errorListener.observeChange(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }


}