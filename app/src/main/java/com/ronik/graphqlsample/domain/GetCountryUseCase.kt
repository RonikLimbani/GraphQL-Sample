package com.ronik.graphqlsample.domain

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code:String):DetailedCountry?{
        return countryClient.getCountry(code = code)
    }
}