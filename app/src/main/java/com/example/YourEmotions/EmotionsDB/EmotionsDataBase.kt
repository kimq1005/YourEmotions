package com.example.YourEmotions.EmotionsDB

import android.content.Context
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EmotionsEntity::class),version=2)
abstract class EmotionsDataBase : RoomDatabase(){
    abstract fun EmotionsDAO() : EmotionsDAO

    companion object{
        private var INSTANCE : EmotionsDataBase? =null

        fun getinstance(context: Context) : EmotionsDataBase?{
            if(INSTANCE==null){
                synchronized(EmotionsDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        EmotionsDataBase::class.java, "emotions.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}