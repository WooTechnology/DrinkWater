package com.crayonwriter.wootechdrinkwater

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class WaterViewModel : ViewModel() {

    private val DEFAULT_GLASSES = 0
    private lateinit var appDatabase: AppDatabase

    fun setDb(appDatabase: AppDatabase) {
        this.appDatabase = appDatabase
    }

    fun getGlasses(): LiveData<WaterEntries> {
        return appDatabase.userDao().getCurrentDay(getCurrentData())
    }

    fun getWeekGlasses(): LiveData<List<WaterEntries>> {
        return appDatabase.userDao().getLastSix()
    }

    /**Method to decrement the number of glasses when the - button is pressed
     *  If the value of glasses is null, use the default glasses value to determine
     *  if the number is valid.
     */
    fun decrementGlasses(glasses: Int) {
        val newNumberOfGlasses =
            if (glasses == 0) {
                glasses
            } else {
                glasses - 1
            }

        val waterEntries = WaterEntries(
            date = getCurrentData(),
            dayOfWeek = "",
            glasses = newNumberOfGlasses.toString()
        )
        InsertGlassAsyncTask().execute(waterEntries)
    }

    /**
     *     Method to increment the number of glasses when the + button is pressed
     *     If the new number of glasses is null, return the default glasses value
     */
    fun incrementGlasses(glasses: Int) {
        val newNumberOfGlasses: Int = glasses.plus(1)
        val waterEntries = WaterEntries(
            date = getCurrentData(),
            dayOfWeek = "",
            glasses = newNumberOfGlasses.toString()
        )
        InsertGlassAsyncTask().execute(waterEntries)
    }

    private fun getCurrentData(): String {
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat("MM-dd-yyyy")
        val formattedDate = formatter.format(date)
        return formattedDate
    }

    private inner class InsertGlassAsyncTask: AsyncTask<WaterEntries, Any, Any>() {

        override fun doInBackground(vararg params: WaterEntries): Any {
            try {
                appDatabase.userDao().addWaterEntry(params[0])
            } catch (e: Exception) {
                return Any()
            }
            return Any()
        }
    }

}
