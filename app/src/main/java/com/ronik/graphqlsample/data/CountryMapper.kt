package com.ronik.graphqlsample.data

import com.ronik.CountriesQuery
import com.ronik.CountryQuery
import com.ronik.graphqlsample.domain.DetailedCountry
import com.ronik.graphqlsample.domain.SimpleCountry


fun CountriesQuery.Country.toSimpleCountry():SimpleCountry{
    return SimpleCountry(
        code=code,
        name = name,
        emoji=emoji,
        capital = capital?:"NO Capital",
        )
}

fun CountryQuery.Country.toDetailedCountry():DetailedCountry{
    return DetailedCountry(
        code=code,
        name = name,
        emoji=emoji,
        capital = capital?:"NO Capital",
        currency = currency?:"No Currency",
        languages = languages.map { it.name },
        continent = continent.name


    )
}