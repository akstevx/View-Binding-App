package com.qucoon.viewbindingapp.module

import com.qucoon.viewbindingapp.viewmodel.BindingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{ BindingViewModel() }
}
