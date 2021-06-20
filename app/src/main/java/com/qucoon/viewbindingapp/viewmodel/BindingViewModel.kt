package com.qucoon.viewbindingapp.viewmodel

import com.qucoon.viewbindingapp.base.BaseViewModel
import com.qucoon.viewbindingapp.utils.SingleLiveEvent
import kotlin.random.Random

class BindingViewModel: BaseViewModel()  {
    val loginText = SingleLiveEvent<String>()
    val nameListener =  SingleLiveEvent<String>()
    val userNameListener =  SingleLiveEvent<String>()
    val gameListener =  SingleLiveEvent<String>()
    val lengthOfThoughtsListener = SingleLiveEvent<String>()
    val clearListener =  SingleLiveEvent<String>()

    val listOfStrings = listOf<String>("Bolu", "Olivia", "Guru", "Steven", "Lota", "Yemisi","Mayokun")

    fun onNamePicked() {
        val i = Random.nextInt(listOfStrings.size)
        nameListener.value = "${listOfStrings[i]} !!!"
    }

    fun onClear(){
        nameListener.value = ""
    }

    fun onResponse(thought: String){
        val lengthOfThoughts = thought.split(" ")
        when {
            lengthOfThoughts.size > 15 -> {
                lengthOfThoughtsListener.value = "${lengthOfThoughts.size} words, that's alot on your mind"
            }

            lengthOfThoughts.size > 8 -> {
                lengthOfThoughtsListener.value = "${lengthOfThoughts.size} words, hmm someones thinking"
            }

            thought == " " -> {
                lengthOfThoughtsListener.value = "Think you DimWitt"
            }

            lengthOfThoughts.size == 1 -> {
                lengthOfThoughtsListener.value = "you thought of ${lengthOfThoughts.size} word"
            }

            else -> {
                lengthOfThoughtsListener.value = "you thought of ${lengthOfThoughts.size} words"
            }
        }
    }

    fun onClearThoughts() {
        clearListener.value = ""
    }

    fun onResponse(firstName: String, lastName: String) {
        if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
            userNameListener.value = "Hi ${firstName} ${lastName}, hope you're enjoying this lecture"
        } else {
            when{
                firstName.isEmpty() && lastName.isNotEmpty() -> userNameListener.value =  "Surname is $lastName, you haven't told us your name"
                firstName.isNotEmpty() && lastName.isEmpty() -> userNameListener.value =  "Okay your name is ${firstName} ...??"
                firstName.isEmpty() && lastName.isEmpty() -> userNameListener.value =  "Please be serious, fill both fields"
            }
        }
    }

    fun moveToGame(firstName: String, lastName: String){
        if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
            gameListener.value = "$firstName $lastName"
        } else gameListener.value = ""
    }

}