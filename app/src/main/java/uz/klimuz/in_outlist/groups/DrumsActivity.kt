package uz.klimuz.in_outlist.groups

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import uz.klimuz.in_outlist.MainActivity
import uz.klimuz.in_outlist.R
import uz.klimuz.in_outlist.utils.Instrument
import uz.klimuz.in_outlist.utils.InstrumentAdapter

class DrumsActivity: AppCompatActivity() {
    val drumsList: ArrayList<Instrument> = ArrayList()
    var currentDrumsList: ArrayList<Instrument> = ArrayList()


    lateinit var drums_list_view: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drums)

        initInstruments()
        initListView()

        if (MainActivity.drumsActivityLaunchCounter == 1){
            currentDrumsList.clear()
            currentDrumsList.addAll(drumsList)
        }else {
            if (MainActivity.drumsSelected.isEmpty()) {
                currentDrumsList.clear()
                currentDrumsList.addAll(drumsList)
            } else {
                currentDrumsList.clear()
                currentDrumsList.addAll(MainActivity.drumsSelected)
            }
        }
        findViewById<Button>(R.id.saveButton).setOnClickListener{
            MainActivity.drumsSelected.clear()
            MainActivity.drumsSelected.addAll(currentDrumsList)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initListView() {
        drums_list_view = findViewById(R.id.drums_list_view)
 //      val pickupSpinner :Spinner = findViewById(R.id.pickupSpinner)

        val adapter = InstrumentAdapter(this, R.layout.instrument_item, currentDrumsList)
        drums_list_view.adapter = adapter
 //       pickupSpinner.adapter = pickupSpinnerAdapter
    }

    private fun initInstruments() {
        drumsList.add(Instrument("KICK IN",1, 0, pickup = "condencer"))
        drumsList.add(Instrument("KICK OUT",1, 1))
        drumsList.add(Instrument("SNARE TOP",1, 1))
        drumsList.add(Instrument("SNARE BOT",1, 0))
        drumsList.add(Instrument("HAT",1, 1, pickup = "condencer"))
        drumsList.add(Instrument("TOMS",5, 2))
        drumsList.add(Instrument("FLOOR TOMS",5,0))
        drumsList.add(Instrument("OVER",2, 2,pickup = "condencer"))
        drumsList.add(Instrument("SNARE 2",2, 0))
        drumsList.add(Instrument("ELECTRO",4, 0,true, pickup = "D.I. box"))



    }
}