package ru.niolasdev.coroutinesdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.toolbar
import ru.niolasdev.coroutinesdemo.domain.LaunchMission
import ru.niolasdev.coroutinesdemo.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val missionData = intent.getParcelableExtra<LaunchMission>(
            MISSION_DATA_KEY
        )
        missionData?.let {
            toolbar.title = it.name
            if (!missionData.photoUrls.isNullOrEmpty()) {
                Glide.with(this).load(missionData.photoUrls[0]).into(missionPhoto)
            }
            detailsText.text = if (missionData.details.isNullOrBlank())
                                    getString(R.string.no_details_available)
                               else
                                    missionData.details
        }

        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        const val MISSION_DATA_KEY = "MISSION_DATA"
    }
}
