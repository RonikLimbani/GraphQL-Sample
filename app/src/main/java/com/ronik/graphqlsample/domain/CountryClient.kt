package com.ronik.graphqlsample.domain


interface CountryClient {
//    suspend fun getCountries():List<CountryQuery.Country>
    suspend fun getCountries():List<SimpleCountry>
    suspend fun getCountry(code:String):DetailedCountry?

}