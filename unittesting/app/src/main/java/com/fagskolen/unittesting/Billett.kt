package com.fagskolen.unittesting

data class Billett(
    val fraSone: Sone,
    val tilSone: Sone,
    val profil: Profil
) {
    /**
     * Ombordtillegg legges ikke alltid selv om den kjøpes ombord.
     * Denne funksjonen gir svar på det
     */
    fun gjelderOmbordTillegg(): Boolean {
        return profil != Profil.Barn || fraSone == Sone.Sentrum
    }

    /**
     * @param ombord Sett til "true" dersom du vil ha pris for billett kjøpt ombord
     * "false" dersom billett kjøpt på forhånd.
     */
    fun prisKroner(ombord: Boolean): Int {
        var pris = 20
        if (profil == Profil.Barn) pris = 15
        if (gjelderOmbordTillegg() && ombord) pris += 10
        if (fraSone != tilSone) pris += 7
        if (fraSone == Sone.Sentrum) pris += 5
        return pris
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