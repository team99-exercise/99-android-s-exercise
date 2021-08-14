package co.ninetynine.android.exercise

import android.app.Application
import timber.log.Timber

class NinetyNineExerciseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}