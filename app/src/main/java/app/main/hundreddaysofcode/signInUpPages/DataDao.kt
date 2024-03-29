package app.main.hundreddaysofcode.signInUpPages

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert

@Dao
interface DataDao {

    @Upsert
    suspend fun upsertData(signUpInfo: DataInfo)

    @Delete
    suspend fun deleteData(signUpInfo: DataInfo)
}