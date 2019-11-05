package com.joaaoferreiira.celebridades.util

import com.joaaoferreiira.celebridades.database.entity.FraseEntity

object FrasesUtil {

    fun getFrases(): List<FraseEntity> {
        return listOf(
            FraseEntity(1, 1, "Frase 1"),
            FraseEntity(2, 1, "Frase 2"),
            FraseEntity(3, 1, "Frase 3"),
            FraseEntity(4, 1, "Frase 4"),
            FraseEntity(5, 1, "Frase 5"),
            FraseEntity(6, 1, "Frase 6"),
            FraseEntity(7, 1, "Frase 7"),
            FraseEntity(8, 1, "Frase 8"),
            FraseEntity(9, 1, "Frase 9"),
            FraseEntity(10, 1, "Frase 10")
        )
    }
}