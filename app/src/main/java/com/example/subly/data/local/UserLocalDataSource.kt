package com.example.subly.data.local

import kotlinx.coroutines.flow.Flow

/**
 * Interface for local data operations.
 * Allows for different persistence implementations (e.g., Room, Realm, In-memory).
 */
interface UserLocalDataSource {
    suspend fun upsertUser(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
    fun getUsersSortedBy(field: UserSortField): Flow<List<UserEntity>>
}
