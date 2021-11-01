package com.example.YourEmotions.EmotionsDB

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.YourEmotions.utils.myobject


@Entity(tableName = myobject.EMOTIONS_DB_NAME)
data class EmotionsEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int= 0,

    var youremotion :String

        )

