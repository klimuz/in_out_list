package uz.klimuz.in_outlist.groups

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import uz.klimuz.in_outlist.R
import uz.klimuz.in_outlist.utils.Instrument
import uz.klimuz.in_outlist.utils.InstrumentAdapter
import uz.klimuz.in_outlist.utils.PickupSpinnerAdapter

class DrumsActivity: AppCompatActivity() {
    var drumsList: ArrayList<Instrument> = ArrayList()
    val selectedDrumsList: ArrayList<Instrument> = ArrayList()

    lateinit var drums_list_view: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drums)

//        pickupSpinner = findViewById(R.id.pickupSpinner)

        initInstruments()
        initListView()
 //       colorise()
    }

//    private fun colorise() {
//        TODO("Not yet implemented")
//    }

    private fun initListView() {
        drums_list_view = findViewById(R.id.drums_list_view)
 //      val pickupSpinner :Spinner = findViewById(R.id.pickupSpinner)

        val adapter = InstrumentAdapter(this, R.layout.instrument_item, drumsList)
        drums_list_view.adapter = adapter
 //       pickupSpinner.adapter = pickupSpinnerAdapter
    }

    private fun initInstruments() {
        drumsList.add(Instrument("KICK IN",1, pickup = "condencer"))
        drumsList.add(Instrument("KICK OUT",1, 1))
        drumsList.add(Instrument("SNARE TOP",1, 1))
        drumsList.add(Instrument("SNARE BOT",1))
        drumsList.add(Instrument("HAT",1, 1, pickup = "condencer"))
        drumsList.add(Instrument("TOMS",5, 2))
        drumsList.add(Instrument("FLOOR TOMS",5,))
        drumsList.add(Instrument("OVER",2, 2,pickup = "condencer"))
        drumsList.add(Instrument("SNARE 2",2))
        drumsList.add(Instrument("ELECTRO",4, pickup = "D.I. box"))



    }
}