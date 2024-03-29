package app.main.hundreddaysofcode.signInUpPages

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataInfo(
    val username : String,
    val email : String,
    val password : String,
    val repeatingPassword: String,

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
