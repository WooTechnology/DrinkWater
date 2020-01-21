package com.crayonwriter.wootechdrinkwater

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WaterEntries(
    @PrimaryKey
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "glasses") val glasses: String
)



