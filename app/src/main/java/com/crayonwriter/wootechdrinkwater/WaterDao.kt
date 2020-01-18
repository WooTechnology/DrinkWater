package com.crayonwriter.wootechdrinkwater

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface WaterDao{
//    @Query("SELECT * FROM WaterEntries")
//    fun getAll(): List<WaterEntries>

    @Query("SELECT * FROM WaterEntries DESCENDING LIMIT 5")
    fun getLastSix(): LiveData<List<WaterEntries>>

    @Query("SELECT * FROM WaterEntries WHERE date = :todaysDate")
    fun getCurrentDay(todaysDate: String): LiveData<WaterEntries>

    @Insert(onConflict = REPLACE)
    fun addWaterEntry(waterEntries: WaterEntries)

    
}