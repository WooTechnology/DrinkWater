package com.crayonwriter.wootechdrinkwater

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WaterViewModel : ViewModel() {

    private val DEFAULT_GLASSES = 0

    private val glasses: MutableLiveData<Int> = MutableLiveData<Int>().also {
        loadGlasses()
    }

    fun getGlasses(): LiveData<Int> {
        return glasses
    }

    private fun loadGlasses() {
        //Whenever we have a database, replace it with actual value
        glasses.postValue(DEFAULT_GLASSES)
    }

    /**Method to decrement the number of glasses when the - button is pressed
     *  If the value of glasses is null, use the default glasses value to determine
     *  if the number is valid.
     */
    fun decrementGlasses() {
        var isValidNumber = false
        var currentNumberOfGlasses: Int = glasses.value ?: DEFAULT_GLASSES
        if (currentNumberOfGlasses > 0) {
            isValidNumber = true
        }

        if (isValidNumber) {
            currentNumberOfGlasses--
        } else {
            Log.d(WaterViewModel::class.java.simpleName, "Can't be negative")
        }
        glasses.postValue(currentNumberOfGlasses)
    }

    /**
     *     Method to increment the number of glasses when the + button is pressed
     *     If the new number of glasses is null, return the default glasses value
     */
    fun incrementGlasses() {
        val newNumberOfGlasses: Int = glasses.value?.plus(1) ?: DEFAULT_GLASSES
        glasses.postValue(newNumberOfGlasses)
    }

}
