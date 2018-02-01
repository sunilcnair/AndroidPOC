package com.sunil.assessment.DI;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.sunil.assessment.BuildConfig;
import com.sunil.assessment.R;
import com.sunil.assessment.business.data.CoreApi;
import com.sunil.assessment.business.data.CoreUseCase;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunil on 31-01-2018.
 * This class give dependency injection. It initialize the Retrofit library and the service provider class.
 */

@Module
public class DIModule {
    private Context mContext;

    public DIModule(Context context) {
        mContext = context;
    }

    /**
     * Core service provider
     * @param coreApi
     * @return
     */
    @Provides
    @Singleton
    public CoreUseCase provideCoreUseCase(CoreApi coreApi) {
        return new CoreUseCase(coreApi);
    }

    /**
     * OkHttp client provider
     * @return
     */
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor);
        } else {
            okHttpClientBuilder
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS);
        }

        return okHttpClientBuilder.build();
    }

    /**
     * Actors api provider
     * @param okHttpClient
     * @return
     */
    @Provides
    @Singleton
    public CoreApi provideCoreApi(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mContext.getApplicationContext().getString(R.string.base_url))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(CoreApi.class);
    }
}
