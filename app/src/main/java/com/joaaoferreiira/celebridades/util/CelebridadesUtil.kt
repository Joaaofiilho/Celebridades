package com.joaaoferreiira.celebridades.util

import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity

object CelebridadesUtil {
    fun getCelebridades(): List<CelebridadeEntity> {
        return listOf(
            CelebridadeEntity(0, "Ana Paula Padrão", R.drawable.ana_paula_padrao),
            CelebridadeEntity(0, "Beyonce", R.drawable.beyonce),
            CelebridadeEntity(0, "Daniel Radcliffe", R.drawable.daniel_radcliffe),
            CelebridadeEntity(0, "Ellen DeGeneres", R.drawable.ellen_degeneres),
            CelebridadeEntity(0, "Emma Watson", R.drawable.emma_watson),
            CelebridadeEntity(0, "Fatima Bernardes", R.drawable.fatima_bernardes),
            CelebridadeEntity(0, "Gloria Maria", R.drawable.gloria_maria),
            CelebridadeEntity(0, "Paola Carosella", R.drawable.paola_carosella),
            CelebridadeEntity(0, "Taylor Swift", R.drawable.taylor_swift),
            CelebridadeEntity(0, "William Bonner", R.drawable.william_bonner)
        )
    }
}