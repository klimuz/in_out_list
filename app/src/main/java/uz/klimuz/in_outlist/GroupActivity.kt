package uz.klimuz.in_outlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import uz.klimuz.in_outlist.utils.*

class GroupActivity: AppCompatActivity() {
    private lateinit var instrumentsListView: ListView
    private val currentInstrumentList: ArrayList<Instrument> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        initListView()

        when(intent.getIntExtra("position", 0)){
            1 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(percussionInstrumentsList)
            }
            2 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(guitarInstrumentsList)
            }
            3 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(keyboardInstrumentsList)
            }
            4 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(nationalInstrumentsList)
            }
            5 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(soloistInstrumentsList)
            }
            6 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(backVocalInstrumentsList)
            }
            7 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(stringInstrumentsList)
            }
            8 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(woodwindInstrumentsList)
            }
            9 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(brassInstrumentsList)
            }
            10 -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(playbackInstrumentsList)
            }
            11 ->{
                currentInstrumentList.clear()
                currentInstrumentList.addAll(extraMicsList)
            }
            else -> {
                currentInstrumentList.clear()
                currentInstrumentList.addAll(drumInstrumentsList)
            }
        }
        findViewById<Button>(R.id.saveButton).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initListView() {
        instrumentsListView = findViewById(R.id.instrumentsListView)

        val adapter = InstrumentAdapter(this, R.layout.instrument_item, currentInstrumentList)
        instrumentsListView.adapter = adapter
    }
}




