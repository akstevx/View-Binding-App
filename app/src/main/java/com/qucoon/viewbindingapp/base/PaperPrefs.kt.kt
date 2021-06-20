package com.qucoon.viewbindingapp.base

import android.app.Application
import android.content.Context
import io.paperdb.Paper
import kotlinx.coroutines.*

class PaperPrefs{


    constructor(application: Application){
        Paper.init(application)
        this.context = application
    }

    constructor(context: Context){
        Paper.init(context)
        this.context = context
    }

    companion object{

        val LOGIN_USERNAME = "LOGIN_USERNAME"
        val SHOW_LOGIN_PAGE = "SHOW_LOGIN_PAGE"
        val USER_EMAIL = "USER_EMAIL"
        val FIRST_NAME = "FIRST_NAME"
        val LAST_NAME = "LAST_NAME"
        val DEVICE_STATUS = "DEVICE_STATUS"
        val IS_PROD = "IS_PROD"
        val CUSTOMER_NAME = "CUSTOERNAME"
        val AUTH_TOKEN = "AUTH_KEY"
        val HAS_DATA = "HAS_DATA"
        val NEEDS_UPGRADE = "NEEDS_UPGRADE"
        val UPGRADE_STATUS = "UPGRADE_STATUS"
        val ACCOUNT_NO = "ACCOUNT_NO"
        val ACCOUNT = "ACCOUNT"
        val PHONENUMBER = "PHONENUMBER"

        val API_USERNAME = "API_USERNAME"



        private val CUSTOMERID_KEY = "fwnweni"





    }
    private lateinit var context: Context


    fun PaperPrefs.getBooleanPref(key: String):Boolean{
        return key.getBooleanPref()
    }

    fun PaperPrefs.getBooleanPref(key: String, defaultValue:Boolean):Boolean{
        return key.getBooleanPref(defaultValue)
    }
    private fun getStringFromPref(key:String):String{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,"")
            }.await()
        }
    }

    private fun getStringFromPref(key:String,deafult:String):String{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,deafult)
            }.await()
        }
    }

    private fun saveBooleanToPref(key:String,value:Boolean){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,value)
            }
        }
    }

     fun getBooleanFromPref(key:String):Boolean{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,false)
            }.await()
        }
    }

    fun getBooleanFromPref(key:String,defaultvalue:Boolean):Boolean{
        return runBlocking {
            async(Dispatchers.IO){
                Paper.book().read(key,defaultvalue)
            }.await()
        }
    }


    private fun <T:Any> saveAnyToPref(key: String,data:T){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,data)
            }
        }
    }

    fun getUserName(): String {
        return LOGIN_USERNAME.getStringPref()
    }

    fun getUserPhone(): String {
        return PHONENUMBER.getStringPref()
    }


    fun getCustomerID():String{
        return CUSTOMERID_KEY.getStringPref()
    }

    fun getCustomerFirstName():String{
        return FIRST_NAME.getStringPref()
    }

    fun getCustomerLastName():String{
        return LAST_NAME.getStringPref()
    }

    fun getCustomerName():String{
        return CUSTOMER_NAME.getStringPref()
    }

    fun getAccountNo():String{
        return ACCOUNT_NO.getStringPref()
    }




    private fun <T:Any> getAnyFromPref(key:String):T{
        return runBlocking {
            async(Dispatchers.IO){
                    Paper.book().read(key) as T
            }.await()
        }
    }

    private fun saveStringToPref(key:String,value:String){
        runBlocking {
            withContext(Dispatchers.IO){
                Paper.book().write(key,value)
            }
        }
    }


    fun String.getStringPref():String{
        return getStringFromPref(this)
    }

    fun String.getStringPref(default:String):String{
        return getStringFromPref(this,default)
    }

    fun String.saveStringPref(value:String){

        saveStringToPref( this,value)
    }

    fun String.getBooleanPref():Boolean{
        return getBooleanFromPref(this)
    }
    fun String.getBooleanPref(default:Boolean):Boolean{
        return getBooleanFromPref(this,default)
    }

    fun <T:Any> String.getAnyPref():T{
        return getAnyFromPref(this)
    }
    fun <T:Any> String.saveAnyPref(data:T){
        return saveAnyToPref(this,data)
    }

    fun String.saveBooleanPref(value:Boolean){
        saveBooleanToPref(this,value)
    }





}

fun PaperPrefs.savePref(key: String, value: Any){
    when(value){
        is String -> {key.saveStringPref(value)}
        is Boolean -> {key.saveBooleanPref(value)}
        else -> {
            key.saveAnyPref(value)
        }
    }
}
fun PaperPrefs.getStringPref(key: String):String{
    return key.getStringPref()
}
fun PaperPrefs.getBooleanPref(key: String):Boolean{
    return key.getBooleanPref()
}
fun PaperPrefs.getBooleanPref(key: String, defaultValue:Boolean):Boolean{
    return key.getBooleanPref(defaultValue)
}
fun <T:Any> PaperPrefs.getAnyPref(key: String):T{
    return key.getAnyPref()
}





enum class ParentApproveStatus(val value:String){
    APPROVED("APPROVE"),PENDING("PENDING"),REJECTED("REJECTED")
}