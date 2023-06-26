package uz.klimuz.in_outlist.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import uz.klimuz.in_outlist.R

class PickupSpinnerAdapter (context: Context, private val layout: Int, private val contentList: ArrayList<String>)
    : ArrayAdapter<String?>(context, layout, contentList as List<String?>) {
    private val inflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(layout, parent, false)
        val  viewHolder = ViewHolder(view)

        val instrument = contentList[position]





        return view
    }
    private class ViewHolder constructor(view: View) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val pickupSpinner: Spinner = view.findViewById(R.id.pickupSpinner)
        val stereoCheckBox: CheckBox = view.findViewById(R.id.stereoCheckBox)
        val quantitySpinner: Spinner = view.findViewById(R.id.quantitySpinner)
    }
}
