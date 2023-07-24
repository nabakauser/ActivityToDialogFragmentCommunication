package com.example.activitytodialogfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.activitytodialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var data: String? = null
    var dialogFragment: DialogFrag? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        countdownTimerUi()
        openDialogFragment()
    }

    private fun openDialogFragment(){
        dialogFragment = DialogFrag()
        val bundle = Bundle()
            bundle.putString(Constants.TEXT, data.toString())
            dialogFragment?.arguments = bundle
            dialogFragment?.show(supportFragmentManager, Constants.DIALOG_TAG)
    }

    @SuppressLint("SetTextI18n")
    private fun countdownTimerUi() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                data = (millisUntilFinished/1000).toString()
                binding?.uiEtText?.text = data
                if(dialogFragment != null) {
                    dialogFragment?.updateText(data)

                }
            }
            override fun onFinish() {
                binding?.uiEtText?.text = "done!"
                if(dialogFragment != null) {
                    dialogFragment?.dismiss()
                }
            }
        }.start()
    }
}

