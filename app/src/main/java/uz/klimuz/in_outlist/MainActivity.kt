package uz.klimuz.in_outlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import uz.klimuz.in_outlist.utils.TooManyChannelsDialog
import uz.klimuz.in_outlist.utils.countAllChannels

class MainActivity : AppCompatActivity() {
    companion object{
        var selectedDesk = 0
        var upperText = "desk: Generic"
    }
    private lateinit var upperTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var genericDeskRadiobutton: RadioButton
    private lateinit var yamahaPm5dRadiobutton: RadioButton
    private lateinit var x32Radiobutton: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.consolesRadioGroup)
        genericDeskRadiobutton = findViewById(R.id.genericDeskRadiobutton)
        yamahaPm5dRadiobutton = findViewById(R.id.yamahaPm5dRadiobutton)
        x32Radiobutton = findViewById(R.id.x32Radiobutton)
        upperTextView = findViewById(R.id.deskTextView)
        val listView: ListView = findViewById(R.id.bandGroupsListView)
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, GroupActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }
        when(selectedDesk){
            1 -> {
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_pm5d)))
                yamahaPm5dRadiobutton.isChecked = true
            }
            2 -> {
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_x32)))
                x32Radiobutton.isChecked = true
            }
            else -> {
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_generic)))
                genericDeskRadiobutton.isChecked = true
            }
        }
        upperTextView.text = upperText
    }
    fun nextStep(view: View) {
        if (countAllChannels() > 48) {
            val tooManyChannelsDialog = TooManyChannelsDialog()
            val manager = supportFragmentManager
            tooManyChannelsDialog.show(manager, "myDialog")
        } else {
            val intent = Intent(this, ChannelsListActivity::class.java)
            startActivity(intent)
        }
        Log.i("three", selectedDesk.toString())
    }
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.yamahaPm5dRadiobutton -> if (checked) {
            selectedDesk = 1
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_pm5d)))
            }
            R.id.x32Radiobutton -> if (checked) {
            selectedDesk = 2
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_x32)))
            }
            else -> {
                selectedDesk = 0
                upperText = getString(R.string.deskUpperText, (getString(R.string.console_type_generic)))
            }
        }
        upperTextView.text = upperText
    }
}