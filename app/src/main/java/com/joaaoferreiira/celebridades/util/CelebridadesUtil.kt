package com.joaaoferreiira.celebridades.util

import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity

object CelebridadesUtil {
    fun getCelebridades(): List<CelebridadeEntity> {
        return listOf(
            CelebridadeEntity(1, "Justin Bieber", R.drawable.justin_bieber),
            CelebridadeEntity(2, "Beyonce", R.drawable.beyonce),
            CelebridadeEntity(3, "Daniel Radcliffe", R.drawable.daniel_radcliffe),
            CelebridadeEntity(4, "Ellen DeGeneres", R.drawable.ellen_degeneres),
            CelebridadeEntity(5, "Emma Watson", R.drawable.emma_watson),
            CelebridadeEntity(6, "Fatima Bernardes", R.drawable.fatima_bernardes),
            CelebridadeEntity(7, "Gloria Maria", R.drawable.gloria_maria),
            CelebridadeEntity(8, "Paola Carosella", R.drawable.paola_carosella),
            CelebridadeEntity(9, "Taylor Swift", R.drawable.taylor_swift),
            CelebridadeEntity(10, "William Bonner", R.drawable.william_bonner)
        )
    }
}