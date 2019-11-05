package com.joaaoferreiira.celebridades.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joaaoferreiira.celebridades.database.entity.FraseEntity

@Dao
interface FraseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salvarFrase(fraseEntity: FraseEntity)

    @Query("SELECT * from frase where celebridade_id = :celebridadeId")
    suspend fun getFrasesDe(celebridadeId: Int): List<FraseEntity>
}