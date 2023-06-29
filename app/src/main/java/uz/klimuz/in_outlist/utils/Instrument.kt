package uz.klimuz.in_outlist.utils

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import uz.klimuz.in_outlist.R

class Instrument (
    var name: String, var possibleQuantity: Int, var selectedQuantity: Int,
    var stereo: Boolean = false, var  pickup: String = "mic")



