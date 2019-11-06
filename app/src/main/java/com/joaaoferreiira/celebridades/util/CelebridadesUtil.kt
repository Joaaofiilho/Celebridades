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
            CelebridadeEntity(6, "Fatima Bernardes", R.drawable.fatima_bernardes),
            CelebridadeEntity(7, "Gloria Maria", R.drawable.gloria_maria),
            CelebridadeEntity(14, "Emma Watson", R.drawable.emma_watson),
            CelebridadeEntity(15, "Chico Buarque", R.drawable.chico_buarque),
            CelebridadeEntity(16, "Lulu Santos", R.drawable.lulu_santos),
            CelebridadeEntity(17, "Marília Mendonça", R.drawable.marilia_mendonca),
            CelebridadeEntity(18, "Lady Gaga", R.drawable.lady_gaga),
            CelebridadeEntity(19, "Will Smith", R.drawable.will_smith),
            CelebridadeEntity(20, "Taylor Swift", R.drawable.taylor_swift)
        )
    }
}