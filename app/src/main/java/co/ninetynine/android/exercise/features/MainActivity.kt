package co.ninetynine.android.exercise.features

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.ninetynine.android.exercise.R
import co.ninetynine.android.exercise.base.BaseActivity
import co.ninetynine.android.exercise.databinding.ActivityMainBinding
import co.ninetynine.android.exercise.model.Page
import co.ninetynine.android.exercise.model.event.VisibilityEvent
import co.ninetynine.android.exercise.util.Constants
import co.ninetynine.android.exercise.util.Util
import com.google.gson.Gson
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.json.JSONObject
import timber.log.Timber


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private var page: Page? = null
    private var sectionRecyclerAdapter: SectionRecyclerAdapter? = null
    private var currentVisibilityConditions = HashMap<String, Any?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
        renderPage()
    }

    private fun initUI() {
        binding.btnReset.setOnClickListener { renderPage() }
        binding.btnSearch.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Current Page Data")
                .setMessage(JSONObject(Gson().toJson(page)).toString(4))
                .setNegativeButton(R.string.label_close, null)
                .show()
        }
        //sections
        binding.rvSections.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        sectionRecyclerAdapter = SectionRecyclerAdapter()
        binding.rvSections.adapter = sectionRecyclerAdapter
    }

    private fun renderPage() {
        initPage()
        //page title
        page?.title?.let {
            supportActionBar?.title = page?.title
        }

        //show page sections
        if (page?.sections?.isNullOrEmpty() == true) {
            renderEmptyView()
        } else {
            checkInitialVisibleConditions()
            renderSectionList()
        }
    }

    private fun initPage() {
        //TODO create not nullable local data model and reduce null check
        //get page data from local
        page = Util.getSampleForm(this)
        Timber.d(page.toString())
    }

    private fun renderEmptyView() {
        binding.tvEmpty.visibility = View.VISIBLE
        binding.clContent.visibility = View.GONE
    }

    private fun renderSectionList() {
        binding.tvEmpty.visibility = View.GONE
        binding.clContent.visibility = View.VISIBLE
        checkVisibleConditions()
        binding.rvSections.recycledViewPool.clear()
        sectionRecyclerAdapter = SectionRecyclerAdapter()
        sectionRecyclerAdapter?.notifyDataSetChanged()
        binding.rvSections.adapter = sectionRecyclerAdapter
        sectionRecyclerAdapter?.setDatas(page?.sections?.filter { it.isVisible } ?: emptyList())
    }

    private fun checkInitialVisibleConditions() {//initial visible conditions
        for (section in page?.sections ?: emptyList()) {
            for (row in section.rows ?: emptyList()) {
                if (row.type == Constants.ROW_TYPE_RADIO || row.type == Constants.ROW_TYPE_CHECKBOX) {
                    if (!row.key.isNullOrBlank() || row.value != null) {
                        currentVisibilityConditions[row.key ?: ""] = row.value
                    }
                }
            }
        }
    }

    private fun checkVisibleConditions() {
        page?.sections?.forEachIndexed { index, section ->
            if (section.visible_conditions == null) {
                page?.sections!![index].isVisible = true
            } else {
                for (vhm in section.visible_conditions) {
                    for (key in vhm?.keys?.toList() ?: emptyList()) {
                        if (currentVisibilityConditions.containsKey(key)) {
                            page?.sections!![index].isVisible =
                                vhm?.get(key) == currentVisibilityConditions[key].toString()
                        } else {
                            page?.sections!![index].isVisible = true
                        }
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onVisibilityEvent(event: VisibilityEvent) {
        if (currentVisibilityConditions[event.key] == event.value) return
        currentVisibilityConditions[event.key] = event.value
        renderSectionList()
    }
}