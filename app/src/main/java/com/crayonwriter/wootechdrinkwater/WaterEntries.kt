package com.crayonwriter.wootechdrinkwater

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class waterEntries(
    @PrimaryKey
    @ColumnInfo(name = "date")
    val date: String = drinkDate.toString(),
    @ColumnInfo(name = "water_glasses")
    val waterGlasses: String
)



