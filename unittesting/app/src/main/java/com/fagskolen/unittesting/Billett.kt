package com.fagskolen.unittesting

class Billett(
    val fraSone: Sone,
    val tilSone: Sone,
    val profil: Profil
) {
    /**
     * Ombordtillegg legges ikke alltid selv om den kjøpes ombord.
     * Denne funksjonen gir svar på det
     */
    fun gjelderOmbordTillegg(): Boolean {
        return false
    }

    /**
     * @param ombord Sett til "true" dersom du vil ha pris for billett kjøpt ombord
     * "false" dersom billett kjøpt på forhånd.
     */
    fun prisKroner(ombord: Boolean): Int {
        return 0
    }
}

enum class Profil {
    Voksen,
    Barn
}

enum class Sone {
    Nord1,
    Nord2,
    Vest1,
    Sentrum
}