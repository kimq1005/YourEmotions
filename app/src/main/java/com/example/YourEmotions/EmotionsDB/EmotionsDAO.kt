package com.example.YourEmotions.EmotionsDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.YourEmotions.utils.myobject


@Dao
interface EmotionsDAO {

    @Insert(onConflict = REPLACE)
    fun emotionsinsert(emotionsEntity: EmotionsEntity)


    @Query("SELECT * FROM ${myobject.EMOTIONS_DB_NAME}")
    fun emotionsgetAll() : List<EmotionsEntity>

    @Delete
    fun emotionsdelete(emotionsEntity: EmotionsEntity)
}