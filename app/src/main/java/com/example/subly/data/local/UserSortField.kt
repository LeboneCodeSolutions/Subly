package com.example.subly.data.local

enum class UserSortField (val column: String){
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    JOIN_DATE("joiningDate"),
    EMAIl_ADDRESS("emailAddress"),
    VERIFICATION_STATUS("verificationStatus"),
    SYNC_STATUS( "syncStatus"),
    FIREBASE_UID("firebaseUid"),
    TIER( "tier")
}