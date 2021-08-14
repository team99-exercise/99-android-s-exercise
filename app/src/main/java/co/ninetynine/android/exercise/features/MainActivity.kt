package co.ninetynine.android.exercise.features

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.R
import co.ninetynine.android.exercise.databinding.ActivityMainBinding
import co.ninetynine.android.exercise.model.Page
import co.ninetynine.android.exercise.model.Section
import co.ninetynine.android.exercise.util.Util
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var page: Page? = null
    private var sectionRecyclerAdapter: SectionRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //TODO create not nullable local data model and reduce null check
        //get page data from local
        page = Util.getSampleForm(this)
        Timber.d(page.toString())

        initUI()
        //page title
        page?.title?.let {
            supportActionBar?.title = page?.title
        }

        //show page sections
        if (page?.sections?.isNullOrEmpty() == true) {
            renderEmptyView()
        } else {
            renderSectionList(page?.sections!!)
        }
    }

    private fun initUI() {
        binding.rvSections.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        sectionRecyclerAdapter = SectionRecyclerAdapter()
        binding.rvSections.adapter = sectionRecyclerAdapter
    }

    private fun renderEmptyView() {
        binding.tvEmpty.visibility = View.VISIBLE
        binding.rvSections.visibility = View.GONE
    }

    private fun renderSectionList(sections: List<Section>) {
        binding.tvEmpty.visibility = View.GONE
        binding.rvSections.visibility = View.VISIBLE
        sectionRecyclerAdapter?.setDatas(sections)
    }

}