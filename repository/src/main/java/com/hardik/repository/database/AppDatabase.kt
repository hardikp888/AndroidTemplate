package com.hardik.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hardik.repository.database.dao.HeroesDao
import com.hardik.repository.model.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun heroesDao(): HeroesDao
}