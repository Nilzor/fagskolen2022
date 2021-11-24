package com.fagskolen.json

data class Country(
    var country: String,
    var capital: String,
)

class CountryList : List<Country> by mutableListOf()