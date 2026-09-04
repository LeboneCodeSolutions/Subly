package com.example.subly.data.local

import androidx.sqlite.db.SimpleSQLiteQuery
import kotlinx.coroutines.flow.Flow

/**
 * Local data source for User data.
 * Delegates all persistence work to [UserDAO] — Room's generated
 * implementation is injected here so this class stays testable
 * and has no SQL logic of its own beyond sort-query construction.
 */
class UserDiskDataSource(private val dao: UserDAO) : UserLocalDataSource {

    override suspend fun upsertUser(user: UserEntity) = dao.upsertUser(user)
    override suspend fun deleteUser(user: UserEntity) = dao.deleteUser(user)

    override fun getUsersSortedBy(field: UserSortField): Flow<List<UserEntity>> {
        val query = SimpleSQLiteQuery("SELECT * FROM user ORDER BY ${field.column} ASC")
        return dao.getUsersSorted(query)
    }
}