package com.joaaoferreiira.celebridades.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "celebridadeEntity")
data class CelebridadeEntity(
    @PrimaryKey
    val id: Int,
    var nome: String,
    var imagem: Int)