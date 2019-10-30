package com.iscreamreport.xcaliper.sample

import androidx.multidex.MultiDexApplication
import com.iscreamreport.xcaliper.XCaliper

class SampleApplication: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        XCaliper.start(this)
    }
}