package com.joaaoferreiira.celebridades.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "frase")
@ForeignKey(entity = CelebridadeEntity::class, parentColumns = ["id"], childColumns = ["celebridade_id"], onUpdate = CASCADE, onDelete = CASCADE)
data class FraseEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "celebridade_id")
    val celebridadeId: Int,
    val frase: String
)