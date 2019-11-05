package com.joaaoferreiira.celebridades.database

import androidx.room.*
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity

@Dao
interface CelebridadeDao {

    @Query("SELECT * from celebridadeEntity")
    suspend fun getCelebridades(): List<CelebridadeEntity>

    @Query("SELECT * from celebridadeEntity where id = :id")
    suspend fun getCelebridade(id: Int): CelebridadeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salvarCelebridade(celebridadeEntity: CelebridadeEntity)

    @Update
    suspend fun updateCelebridade(celebridadeEntity: CelebridadeEntity)
}