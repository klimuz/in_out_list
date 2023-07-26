package uz.klimuz.in_outlist

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.band_groups_listView)
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, GroupActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }
}