package com.crayonwriter.wootechdrinkwater

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WaterEntries(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "dayOfWeek") val dayOfWeek: String,
    @ColumnInfo(name = "glasses") val glasses: String
)



