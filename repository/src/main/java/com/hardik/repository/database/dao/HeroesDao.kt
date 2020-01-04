package com.hardik.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.hardik.core.BaseDao
import com.hardik.repository.model.User

@Dao
interface HeroesDao : BaseDao<User> {

    @Query("select * from heroes")
    fun getAllUser(): LiveData<List<User>>
}