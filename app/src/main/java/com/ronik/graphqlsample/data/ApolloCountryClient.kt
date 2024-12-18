package com.ronik.graphqlsample.data

import com.apollographql.apollo.ApolloClient
import com.ronik.CountriesQuery
import com.ronik.CountryQuery
import com.ronik.graphqlsample.domain.CountryClient
import com.ronik.graphqlsample.domain.DetailedCountry
import com.ronik.graphqlsample.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
):CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
       return apolloClient.query(CountriesQuery()).execute().data?.countries?.map { it.toSimpleCountry()} ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
       return apolloClient.query(CountryQuery(country_code = code)).execute().data?.country?.toDetailedCountry()
    }
}