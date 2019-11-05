package com.joaaoferreiira.celebridades.database.entity

import androidx.room.Embedded
import androidx.room.Relation

class Celebridade {
    @Embedded
    var celebridade: CelebridadeEntity? = null

    @Relation(parentColumn = "id", entityColumn = "celebridade_id")
    var frases: List<FraseEntity>? = null
}