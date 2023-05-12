package ru.ponomarchukpn.aston_intensive_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StateFlagsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_flags)
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, StateFlagsActivity::class.java)
    }
}
