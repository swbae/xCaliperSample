package com.iscreamreport.xcaliper.sample

import androidx.multidex.MultiDexApplication
import com.iscreamreport.xcaliper.XCaliper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SampleApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        /**
         * Koin을 사용하는 앱에서 사용
         * 앱에서 Koin 사용 시 startKoin을 사용하면 에러가 발생하여 koin-module 추가
         * SampleApplication.kt 에서 XCaliper.start(this) 전에 startKoin 을 실행
         */
//        startKoin {
//            androidLogger(Level.ERROR)
//            androidContext(this@SampleApplication)
//            modules(coffeeAppModule)
//        }

        XCaliper.start(this)
    }
}