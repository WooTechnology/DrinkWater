package com.crayonwriter.wootechdrinkwater

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(WaterEntries::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): WaterDao
}

