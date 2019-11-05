package com.joaaoferreiira.celebridades.database

import androidx.room.Dao
import androidx.room.Query
import com.joaaoferreiira.celebridades.database.entity.Celebridade

@Dao
interface CelebridadeWithFrasesDao {
    @Query("SELECT * from celebridadeEntity")
    suspend fun getCelebridadeComFrases(): List<Celebridade>

    @Query("SELECT * from celebridadeEntity where id = :celebridadeId")
    suspend fun getCelebridadeComFrase(celebridadeId: Int): Celebridade
}