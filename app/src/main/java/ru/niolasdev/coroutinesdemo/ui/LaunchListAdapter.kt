package ru.niolasdev.coroutinesdemo.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.launch_list_item.view.*
import ru.niolasdev.coroutinesdemo.domain.LaunchMission
import ru.niolasdev.coroutinesdemo.R
import ru.niolasdev.coroutinesdemo.extensions.formatBrief
import ru.niolasdev.coroutinesdemo.extensions.inflate
import java.util.*

class LaunchListAdapter(private val data: List<LaunchMission>,
                        private val action: (LaunchMission) -> Unit)
    : RecyclerView.Adapter<LaunchListAdapter.LaunchItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchItemHolder {
        val inflatedView = parent.inflate(R.layout.launch_list_item, false)
        return LaunchItemHolder(inflatedView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: LaunchItemHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class LaunchItemHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        var data: LaunchMission? = null

        init {
            v.setOnClickListener(this)
        }

        fun bind(launchMission: LaunchMission) {
            data = launchMission
            itemView.missionNameText.text = launchMission.name
            itemView.missionDateText.text = launchMission.launchDate?.let { Date(it).formatBrief() }
            Glide.with(itemView.context).load(launchMission.iconUrl).into(itemView.missionImage)
        }

        override fun onClick(v: View?) {
            data?.let { action.invoke(it) }
        }
    }
}