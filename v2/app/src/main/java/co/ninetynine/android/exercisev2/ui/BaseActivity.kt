package co.ninetynine.android.exercisev2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createThisViewBinding()
        setContentView(binding.root)
    }

    abstract fun createThisViewBinding(): T

    protected fun getThisViewBinding() = binding

}
