package uz.klimuz.in_outlist.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import uz.klimuz.in_outlist.MainActivity
import uz.klimuz.in_outlist.R

class InstrumentAdapter(context: Context, private val layout: Int, private val instrumentList: ArrayList<Instrument>)
    : ArrayAdapter<Instrument?>(context, layout, instrumentList as List<Instrument?>){

        private val inflater = LayoutInflater.from(context)

    val pickupItemList = arrayOf( "mic", "condencer", "D.I. box")
    val quantityItemList = arrayOf( "X0", "X1", "X2", "X3", "X4", "X5", "X6", "X7", "X8", "X9", "X10")


        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(layout, parent, false)
        val  viewHolder = ViewHolder(view)

        val instrument = instrumentList[position]


        viewHolder.nameTextView.text = instrument.name
//adapters for spinners
        val pickupSpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, pickupItemList)
        val quantitySpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, quantityItemList)
            viewHolder.pickupSpinner.adapter = pickupSpinnerAdapter
            viewHolder.quantitySpinner.adapter = quantitySpinnerAdapter
//quantity spinner operator
            viewHolder.quantitySpinner.setSelection(instrument.selectedQuantity)
            viewHolder.quantitySpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                instrument.selectedQuantity = position

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            }

        }
//checkbox operator
            viewHolder.stereoCheckBox.setChecked(instrument.stereo)
            viewHolder.stereoCheckBox.setOnCheckedChangeListener{ _, isChecked ->
                instrument.stereo = isChecked
            }
//pickup spinner operator
            when (instrument.pickup){
                "condencer" -> viewHolder.pickupSpinner.setSelection(1)
                "D.I. box" -> viewHolder.pickupSpinner.setSelection(2)
                else -> viewHolder.pickupSpinner.setSelection(0)
            }
            viewHolder.pickupSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    when(position){
                        1 -> instrument.pickup = "condencer"
                        2 -> instrument.pickup = "D.I. box"
                        else -> instrument.pickup = "mic"

                    }

                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

        return view
    }
    private class ViewHolder constructor(view: View){
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val pickupSpinner: Spinner = view.findViewById(R.id.pickupSpinner)
        val stereoCheckBox: CheckBox = view.findViewById(R.id.stereoCheckBox)
        val quantitySpinner: Spinner = view.findViewById(R.id.quantitySpinner)


    }

}