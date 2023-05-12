package ru.ponomarchukpn.aston_intensive_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private val buttonFlags by bind<AppCompatButton>(R.id.button_show_flags, this)
    private val buttonImage by bind<AppCompatButton>(R.id.button_show_image, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtonListeners()
    }

    private fun setButtonListeners() {
        buttonFlags.setOnClickListener {
            val intent = StateFlagsActivity.newIntent(this)
            startActivity(intent)
        }
        buttonImage.setOnClickListener {
            val intent = ShowImageActivity.newIntent(this)
            startActivity(intent)
        }
    }
}
