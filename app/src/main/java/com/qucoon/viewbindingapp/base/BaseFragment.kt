package com.qucoon.viewbindingapp.base

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.android.ext.android.inject

import kotlin.coroutines.CoroutineContext


open class BaseFragment : Fragment(), CoroutineScope {


     //val backgroundRepository:BackgroundWorkRepository by inject()
    lateinit var mFragmentNavigation: FragmentNavigation
    lateinit  var alertDialog: AlertDialog
    val paperPrefs: PaperPrefs by inject()


    val backgroudJobs =  Job()
    override val coroutineContext: CoroutineContext
        get() = backgroudJobs + Dispatchers.Main



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }




//    fun isAccountApproved():Boolean{
//        return paperPrefs.parentalApprovalStatus() == ParentApproveStatus.APPROVED
//    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigation) {
            mFragmentNavigation = context
            alertDialog = SpotsDialog.Builder()
                    .setContext(context)
                    .setMessage("Loading...")
                    .setCancelable(false)
                    .build()

        }
    }

    fun needsUpgrade() =  paperPrefs.getBooleanFromPref(PaperPrefs.NEEDS_UPGRADE,true)
    interface FragmentNavigation {
        fun pushFragment(fragment: Fragment)
        fun popFragment()
        fun popFragments(n:Int)
        fun openDialogFragment(fragment:DialogFragment)
        fun openBottomDialogFragment(bottomSheetDialogFragment: BottomSheetDialogFragment?)
        fun     openBottomSheet(bottomSheetDialogFragment: BottomSheetDialogFragment)
        fun clearStack()
        fun clearDialogFragmentStack()
        fun switchFragment(index: Int)
    }

    override fun onDestroy() {
        super.onDestroy()
        cancelAllJobs()
    }
    fun cancelAllJobs(){
        try{
            backgroudJobs.cancel()
        }catch (ex:Exception){

        }
    }
//    fun showloadingDialog(show:Boolean){
//        if(show){
//            alertDialog.show()
//        } else {
//            alertDialog.hide()
//
//        }
//
//    }

//
//    fun setUpObservers(viewModel: BaseViewModel){
//        setUpErrorHandler(viewModel)
//        setUpLoading(viewModel)
//    }
//
//    fun setUpErrorHandler(viewModel: BaseViewModel){
//        viewModel.showError.observeChange(this){showError(it)}
//    }
//
//    fun setUpErrorHandler(viewModel: BaseViewModel, action:()->Unit){
//        viewModel.showError.observeChange(this){
//            action()
//            //showError(it)
//        }
//    }


//    fun setUpLoading(viewModel: BaseViewModel){
//        viewModel.showLoading.observeChange(this){status -> showLoading(status)}
//    }

//    fun showLoading(status:Boolean){
//        when(val activity = requireActivity()){
//            is MainActivity -> activity.showLoading(status)
//            is IntroActivity -> activity.showLoading(status)
//            else ->  if (status) alertDialog.show() else alertDialog.dismiss()
//        }
//
//    }
//
//    fun showError(errorMessage:String){
//
//        mFragmentNavigation.openBottomSheet(SuccessBottomsheetFragment.newInstance("Error!", errorMessage, false))
//
//    }

}
