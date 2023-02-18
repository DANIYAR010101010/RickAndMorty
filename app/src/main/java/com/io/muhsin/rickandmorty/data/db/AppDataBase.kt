package com.io.muhsin.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.io.muhsin.rickandmorty.models.search.SearchResponse


@Database(entities = [SearchResponse::class], version = 1, exportSchema = true)
abstract class AppDataBase: RoomDatabase(){

    abstract fun getResponseDao():ResultDao
}