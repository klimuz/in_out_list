package uz.klimuz.in_outlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import uz.klimuz.in_outlist.utils.Channel
import uz.klimuz.in_outlist.utils.ChannelAdapter
import uz.klimuz.in_outlist.utils.mainFunction

class ChannelsListActivity : AppCompatActivity() {
    var finalList: ArrayList<Channel> = ArrayList()
    private lateinit var channelsListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channels_list)
        initListView()
    }
    private fun initListView() {
        channelsListView = findViewById(R.id.channels_list_view)
        finalList = mainFunction()
        val adapter = ChannelAdapter(this, R.layout.channel_item, finalList)
        channelsListView.adapter = adapter
    }
}

