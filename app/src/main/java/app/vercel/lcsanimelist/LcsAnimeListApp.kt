package app.vercel.lcsanimelist

import android.app.Application
import app.vercel.lcsanimelist.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LcsAnimeListApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@LcsAnimeListApp)
            modules(appModules)
        }
    }
}