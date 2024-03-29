package app.main.hundreddaysofcode.signInUpPages

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DataInfo::class],
    version = 1
)
abstract class SignUpDb: RoomDatabase() {
    abstract val dao : DataDao
}