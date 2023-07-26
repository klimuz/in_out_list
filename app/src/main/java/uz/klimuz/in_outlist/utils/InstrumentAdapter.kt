package uz.klimuz.in_outlist.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import uz.klimuz.in_outlist.R

class InstrumentAdapter(context: Context, private val layout: Int, private val instrumentList: ArrayList<Instrument>)
    : ArrayAdapter<Instrument?>(context, layout, instrumentList as List<Instrument?>){

        private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(layout, parent, false)
        val  viewHolder = ViewHolder(view)

        val instrument = instrumentList[position]


        viewHolder.nameTextView.text = instrument.name
//adapters for spinners
        val pickupSpinnerAdapter = createFromResource(context,R.array.pickupItemList , android.R.layout.simple_spinner_item)
        val quantitySpinnerAdapter = createFromResource(context, R.array.quantityItemList, android.R.layout.simple_spinner_item)
            val stereoSpinnerAdapter = createFromResource(context, R.array.stereoItemList, android.R.layout.simple_spinner_item)
            viewHolder.pickupSpinner.adapter = pickupSpinnerAdapter
            viewHolder.quantitySpinner.adapter = quantitySpinnerAdapter
            viewHolder.stereoSpinner.adapter = stereoSpinnerAdapter
//quantity spinner operator
            viewHolder.quantitySpinner.setSelection(instrument.quantity)
            viewHolder.quantitySpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                instrument.quantity = position

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            }

        }
//pickup spinner operator
            when (instrument.pickup){
                "condenser" -> viewHolder.pickupSpinner.setSelection(1)
                "D.I. box" -> viewHolder.pickupSpinner.setSelection(2)
                "wireless" -> viewHolder.pickupSpinner.setSelection(3)
                "DPA" -> viewHolder.pickupSpinner.setSelection(4)
                "HeadSet" -> viewHolder.pickupSpinner.setSelection(5)
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
                        1 -> instrument.pickup = "condenser"
                        2 -> instrument.pickup = "D.I. box"
                        3 -> instrument.pickup = "wireless"
                        4 -> instrument.pickup = "DPA"
                        5 -> instrument.pickup = "HeadSet"
                        else -> instrument.pickup = "mic"

                    }

                }
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
//stereo spinner operator
        when (instrument.isStereo){
            false -> viewHolder.stereoSpinner.setSelection(0)
            else  -> viewHolder.stereoSpinner.setSelection(1)
        }
        viewHolder.stereoSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position){
                    1 -> instrument.isStereo = true
                    else -> instrument.isStereo = false
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
        val quantitySpinner: Spinner = view.findViewById(R.id.quantitySpinner)
        var stereoSpinner: Spinner = view.findViewById(R.id.stereoSpinner)

    }

}