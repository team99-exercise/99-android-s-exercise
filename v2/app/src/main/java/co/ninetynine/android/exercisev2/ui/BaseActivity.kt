package co.ninetynine.android.exercisev2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
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

    fun <G> LiveData<G>.observe(onDataChanged: (data: G?) -> Unit) =
        observe(this@BaseActivity, onDataChanged)

    fun <G> LiveData<G>.observeNotNull(onDataChanged: (data: G) -> Unit) =
        observe(this@BaseActivity) { if (it != null) { onDataChanged(it) } }

}
