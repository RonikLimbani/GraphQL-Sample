package com.ronik.graphqlsample.di

import com.apollographql.apollo.ApolloClient
import com.ronik.graphqlsample.data.ApolloCountryClient
import com.ronik.graphqlsample.data.LoggingApolloInterceptor
import com.ronik.graphqlsample.domain.CountryClient
import com.ronik.graphqlsample.domain.GetCountriesUseCase
import com.ronik.graphqlsample.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApolloClient() :ApolloClient{
        return ApolloClient.Builder().
        serverUrl("https://countries.trevorblades.com/graphql").
        addInterceptor(LoggingApolloInterceptor()).
        build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient):CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient):GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient):GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }

}