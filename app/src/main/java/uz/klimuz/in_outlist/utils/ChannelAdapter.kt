package uz.klimuz.in_outlist.utils

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import uz.klimuz.in_outlist.R

class ChannelAdapter(context: Context, private val layout: Int, private val channelList: ArrayList<Channel>)
    : ArrayAdapter<Channel?>(context, layout, channelList as List<Channel?>) {

    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = inflater.inflate(layout, parent, false)
        val viewHolder = ViewHolder(view)

        if (channelList[position] != null) {
            val channel = channelList[position]

            viewHolder.numberTextView.text = channel.number.toString()
            viewHolder.nameTextView.text = channel.name
            viewHolder.pickupTextView.text = channel.pickup
        }
            return view

        }
        private class ViewHolder constructor(view: View) {
            val numberTextView: TextView = view.findViewById(R.id.numberTextView)
            val nameTextView: TextView = view.findViewById(R.id.nameTextView)
            val pickupTextView: TextView = view.findViewById(R.id.pickupTextView)

        }


    }


