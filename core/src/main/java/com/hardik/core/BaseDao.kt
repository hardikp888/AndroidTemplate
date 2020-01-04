package com.hardik.core

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    fun insert(vararg obj: T): List<Long>

    @Update
    fun update(vararg obj: T): Int

    @Delete
    fun delete(vararg obj: T): Int
}