package com.fagskolen.unittesting

import org.junit.Assert
import org.junit.Test

class Equality2 {
    // Merk at Billett er data-klasse
    @Test
    fun contentEquality() {
        val billett1 = Billett(Sone.Vest1, Sone.Vest1, Profil.Barn)
        val billett2 = Billett(Sone.Vest1, Sone.Vest1, Profil.Barn)
        Assert.assertEquals(billett1, billett2)
    }

    @Test
    fun referenceEquality() {
        val billett1 = Billett(Sone.Vest1, Sone.Vest1, Profil.Barn)
        val billett2 = Billett(Sone.Vest1, Sone.Vest1, Profil.Barn)
        Assert.assertSame(billett1, billett2)
    }
}