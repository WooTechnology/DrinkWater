package com.crayonwriter.wootechdrinkwater

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WaterDao{
    @Query("SELECT * FROM WaterEntries")
    fun getAll(): List<WaterEntries>

    @Query("SELECT * FROM WaterEntries DESCENDING LIMIT 6")
    fun getLastSix(): List<WaterEntries>

    @Query("SELECT * FROM WaterEntries")
    fun getCurrentDay(): LiveData<List<WaterEntries>> {
        //TODO Rest of function that uses ?: to give current days info or else 0 if null
    return getCurrentDay()}
    
}