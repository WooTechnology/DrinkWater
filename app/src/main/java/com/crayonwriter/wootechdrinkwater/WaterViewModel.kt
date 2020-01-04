package com.crayonwriter.wootechdrinkwater

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WaterViewModel: ViewModel() {

    val glasses: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also {
            loadGlasses()
        }
    }

    fun getGlasses(): LiveData<Int> {
        return glasses
    }

    private fun loadGlasses() {
        //fetch glasses

    }

//Method to decrement the number of glasses when the - button is pressed
    fun decrementGlasses(glasses: Int): Int {
        var isValidNumber = false
        var numberOfGlasses: Int = 1
            if (numberOfGlasses > 0) {
                isValidNumber = true
                numberOfGlasses--
        } else {
                println("You can't have negative glasses!")
            }
return numberOfGlasses
    }

    //Method to increment the number of glasses when the + button is pressed
    fun incrementGlasses(glasses: Int): Int {
        var numberOfGlasses: Int = 1
        numberOfGlasses++
        return numberOfGlasses
    }

}
