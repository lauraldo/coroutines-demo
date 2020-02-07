package ru.niolasdev.coroutinesdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.niolasdev.coroutinesdemo.viewmodel.MissionViewModel
import ru.niolasdev.coroutinesdemo.R
import ru.niolasdev.coroutinesdemo.extensions.startActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MissionViewModel::class.java)
    }

    private lateinit var adapter: LaunchListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        missionListView.layoutManager = linearLayoutManager
        setSupportActionBar(toolbar)
    }

    override fun onResume() {
        super.onResume()
        viewModel.missionLaunchList.observe(this, Observer {
            adapter =
                LaunchListAdapter(it) { missionData ->
                    val extras = Bundle()
                    extras.putParcelable(
                        DetailActivity.MISSION_DATA_KEY,
                        missionData
                    )
                    startActivity<DetailActivity>(
                        extras
                    )
                }
            missionListView.adapter = adapter
        })
    }
}
