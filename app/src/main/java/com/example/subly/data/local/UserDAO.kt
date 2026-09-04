package com.example.subly.data.local

import androidx.room.Dao
import androidx.room.Delete

import androidx.room.RawQuery
import androidx.room.Upsert
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Upsert
   suspend fun upsertUser(userEntity: UserEntity)

    @Delete
   suspend fun deleteUser(userEntity: UserEntity)

   // Queries
    @RawQuery(observedEntities = [UserEntity::class])
    fun getUsersSorted(query: SupportSQLiteQuery): Flow<List<UserEntity>>

}