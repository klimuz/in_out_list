package uz.klimuz.in_outlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import uz.klimuz.in_outlist.groups.DrumsActivity
import uz.klimuz.in_outlist.utils.Instrument

class MainActivity : AppCompatActivity() {
    val band_groups_list = arrayOf("DRUMKIT", "PERCUSSION", "GUITARS", "SYNTHS", "NATIONAL",
        "VOCALS", "STRINGS", "WOODWINDS", "BRASS", "PLAYBACK")
    var adapter: ArrayAdapter<String>? = null

    companion object{
        var drumsActivityLaunchCounter: Int = 0
        val drumsSelected: ArrayList<Instrument> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.band_groups_listView)
        adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, band_groups_list)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
            drumsActivityLaunchCounter ++
            val intent = Intent(this, DrumsActivity::class.java)
            startActivity(intent)
        }
    }
}