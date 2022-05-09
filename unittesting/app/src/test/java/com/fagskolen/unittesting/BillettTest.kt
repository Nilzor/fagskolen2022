package com.fagskolen.unittesting

import org.junit.Assert.*
import org.junit.Test

class BillettTest {
    @Test
    fun `pris - voksenbillett fra sone Vest1 til Vest1 kjøpt på forhånd`() {
        val billett = Billett(Sone.Nord2, Sone.Nord2, Profil.Voksen)
        val pris = billett.prisKroner(false)
        assertEquals(20, pris)
    }

    @Test
    fun `pris - barnebillett fra sone Nord1 til Nord1 kjøpt på forhånd`() {
        val billett = Billett(Sone.Nord1, Sone.Nord1, Profil.Barn)
        val pris = billett.prisKroner(false)
        assertEquals(15, pris)
    }

    @Test
    fun `pris - voksenbillett fra sone Vest1 til Vest1 kjøpt ombord`() {
        val billett = Billett(Sone.Nord2, Sone.Nord2, Profil.Voksen)
        val pris = billett.prisKroner(true)
        assertEquals(30, pris)
    }


    @Test
    fun `pris - barnebillett fra sone Nord1 til Vest1 kjøpt på forhånd`() {
        val billett = Billett(Sone.Nord1, Sone.Vest1, Profil.Barn)
        val pris = billett.prisKroner(false)
        assertEquals(22, pris)
    }

    @Test
    fun `pris - barnebillett fra sone Vest2 til Vest2 kjøpt på forhånd`() {
        val billett = Billett(Sone.Vest1, Sone.Vest1, Profil.Voksen)
        val pris = billett.prisKroner(false)
        assertEquals(20, pris)
    }

    @Test
    fun `pris - voksenbillett fra sone Sentrum til Nord1 kjøp ombord`() {
        val billett = Billett(Sone.Sentrum, Sone.Nord1, Profil.Voksen)
        val pris = billett.prisKroner(true)
        assertEquals(42, pris)
    }
    @Test
    fun `pris - voksenbillett fra sone Sentrum til Sentrum kjøp på forhånd`() {
        val billett = Billett(Sone.Sentrum, Sone.Sentrum, Profil.Voksen)
        val pris = billett.prisKroner(false)
        assertEquals(25, pris)
    }

    // Below ikke i oppgaven

    @Test
    fun `pris - voksenbillett fra sone Sentrum til Sentrum kjøp ombord`() {
        val billett = Billett(Sone.Sentrum, Sone.Sentrum, Profil.Voksen)
        val pris = billett.prisKroner(true)
        assertEquals(35, pris)
    }

    @Test
    fun `barnebileltt fra sone Sentrum til Vest1 kjøpt ombord`() {
        //En barnebileltt fra sone Sentrum til Vest1 kjøpt ombord koster 15 + 7 + 5 + 10 = 37 kr
        val billett = Billett(Sone.Sentrum, Sone.Vest1, Profil.Barn)
        val pris = billett.prisKroner(true)
        assertEquals(37, pris)
    }

}