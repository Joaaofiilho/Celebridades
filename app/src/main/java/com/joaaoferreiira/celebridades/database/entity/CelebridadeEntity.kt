package com.joaaoferreiira.celebridades.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "celebridadeEntity")
data class CelebridadeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nome: String,
    var imagem: Int)