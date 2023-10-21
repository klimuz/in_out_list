package uz.klimuz.in_outlist.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import uz.klimuz.in_outlist.ChannelsListActivity
import uz.klimuz.in_outlist.R

class TooManyChannelsDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Not Enough Channels")
                .setMessage("Not Enough free Channels at this desk, press fix to change desk or reduce channels")
                .setIcon(R.drawable.iosis_logo_danil)
                .setCancelable(true)
                .setPositiveButton("Continue"){_, _ ->
                    val intent = Intent(context, ChannelsListActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Fix"){_, _ ->

                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}


