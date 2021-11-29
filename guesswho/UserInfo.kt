package mx.com.fullcomputer.guesswho

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

//@Entity(tableName = "user")
data class UserInfo(
    val id: Int? = 0,
    val nickname: String? = "",
    val email: String?,
    val password: String?,
    val score: Int? = 0,
    val create_at: Timestamp? = null,
//    @PrimaryKey(autoGenerate = false)
)
