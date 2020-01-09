package com.crayonwriter.wootechdrinkwater

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WaterEntries(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "date") val date: String = (R.id.date).toString(),
    @ColumnInfo(name = "dayOfWeek") val dayOfWeek: String = (R.id.dayOfWeek).toString(),
    @ColumnInfo(name = "glasses") val glasses: String
)



