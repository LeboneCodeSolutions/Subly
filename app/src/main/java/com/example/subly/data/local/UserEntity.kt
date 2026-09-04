package com.example.subly.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val joiningDate: LocalDate,
    val verificationStatus: String,
    val syncStatus: String,
    val firebaseUid: String,
    val tier: String,
    // Surrogate Key
    @PrimaryKey(autoGenerate = true)
    val localId: Int = 0
)
// must encrypt the data at rest,