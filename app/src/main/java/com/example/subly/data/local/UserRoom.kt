package com.example.subly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [UserEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class UserRoom : RoomDatabase() {
    abstract val dao: UserDAO
}