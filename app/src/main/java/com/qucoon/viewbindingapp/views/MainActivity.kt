package com.qucoon.viewbindingapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavLogger
import com.ncapdevi.fragnav.FragNavTransactionOptions
import com.qucoon.viewbindingapp.R
import com.qucoon.viewbindingapp.base.BaseActivity
import com.qucoon.viewbindingapp.base.BaseFragment
import timber.log.Timber

class MainActivity : BaseActivity() {

    val baseFragment = lazy { listOf<BaseFragment>(BlankFragment3()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        initFragNavController(this, baseFragment.value, TAG, supportFragmentManager, R.id.content)
    }


    companion object{
        val TAG = "Intro Activity"
        val GETSTARTED = FragNavController.TAB2
    }

}
