package co.ninetynine.android.exercise.base

import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

abstract class BaseActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this);
    }
}