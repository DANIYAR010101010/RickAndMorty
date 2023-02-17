package com.io.muhsin.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Result::class], version = 1, exportSchema = true)
abstract class AppDataBase: RoomDatabase(){

    abstract fun getResultDao():ResultDao
}