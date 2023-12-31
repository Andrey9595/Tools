package ru.anb.tools

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.anb.login.di.loginModule
import ru.anb.registration.di.registrationModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(loginModule()) + mainModule() + registrationModule())
        }
    }
}