package com.example.kitepkana.di

import android.content.Context
import com.example.kitepkana.data.BuildConfig.BASE_URL
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.data.remote.service.ApiService
import com.example.kitepkana.data.remote.service.AuthorizationService
import com.example.kitepkana.data.remote.utils.AuthInterceptor
import com.example.kitepkana.data.repostory.*
import com.example.kitepkana.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAppPrefs(@ApplicationContext context: Context): AppPrefs {
        return AppPrefs(context)
    }

    @Singleton
    @Provides
    fun provideIntercept(appPrefs: AppPrefs): AuthInterceptor {
        return AuthInterceptor(appPrefs)
    }

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        interceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideCurrencyService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun provideAuthorizationService(retrofit: Retrofit): AuthorizationService =
        retrofit.create(AuthorizationService::class.java)

    @Provides
    fun provideRegisterRepository(
        authorizationService: AuthorizationService,
        appPrefs: AppPrefs
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(authorizationService, appPrefs)
    }

    @Provides
    fun provideLibraryRepository(apiService: ApiService): LibraryRepository {
        return LibraryRepositoryImpl(apiService)
    }

    @Provides
    fun provideBookRepository(apiService: ApiService): BookRepository {
        return BookRepositoryImpl(apiService)
    }

    @Provides
    fun provideFavoritesRepository(apiService: ApiService): FavoritesRepository {
        return FavoritesRepositoryImpl(apiService)
    }

    @Provides
    fun provideReviewsRepository(apiService: ApiService): ReviewsRepository {
        return ReviewsRepositoryImpl(apiService)
    }

    @Provides
    fun provideProfileRepository(apiService: ApiService): ProfileRepository {
        return ProfileRepositoryImpl(apiService)
    }

    @Provides
    fun provideSearchRepository(apiService: ApiService): SearchRepository {
        return SearchRepositoryImpl(apiService)
    }
}