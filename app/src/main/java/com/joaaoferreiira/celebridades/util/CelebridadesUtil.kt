package com.joaaoferreiira.celebridades.util

import com.joaaoferreiira.celebridades.R
import com.joaaoferreiira.celebridades.database.entity.CelebridadeEntity

object CelebridadesUtil {
    fun getCelebridades(): List<CelebridadeEntity> {
        return listOf(
            CelebridadeEntity(1, "Justin Bieber", R.drawable.justin_bieber),
            CelebridadeEntity(2, "Beyonce", R.drawable.beyonce),
            CelebridadeEntity(3, "Daniel Radcliffe", R.drawable.daniel_radcliffe),
            CelebridadeEntity(4, "Wesley Safadão", R.drawable.wesley_safadao),
            CelebridadeEntity(5, "Whindersson Nunes", R.drawable.whindersson_nunes),
            CelebridadeEntity(6, "Ayrton Senna", R.drawable.ayrton_senna),
            CelebridadeEntity(7, "David Goggins", R.drawable.david_goggins),
            CelebridadeEntity(8, "Mestre Yoda", R.drawable.mestre_yoda),
            CelebridadeEntity(9, "Luan Santana", R.drawable.luan_santana),
            CelebridadeEntity(10, "PewDiePie", R.drawable.pew_die_pie),
            CelebridadeEntity(11, "Felipe Neto", R.drawable.felipeneto),
            CelebridadeEntity(12, "Alan Turing", R.drawable.alan_turring),
            CelebridadeEntity(13, "Linux Torvalds", R.drawable.linux_torvalds)


        )
    }
}