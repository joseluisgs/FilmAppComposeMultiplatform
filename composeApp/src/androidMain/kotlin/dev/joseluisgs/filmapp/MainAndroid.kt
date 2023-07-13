package dev.joseluisgs.filmapp

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.joseluisgs.filmapp.di.appModule
import dev.joseluisgs.filmapp.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp

        // Necesitamos el contexto de la aplicación para Koin y SqlDelight
        fun getAppContext(): Context = INSTANCE.applicationContext
    }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        // Importamos el módulo de Koin
        startKoin {
            // androidContext(this@AndroidApp)
            androidContext(getAppContext())
            modules(appModule, databaseModule)
            androidLogger()
        }
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

