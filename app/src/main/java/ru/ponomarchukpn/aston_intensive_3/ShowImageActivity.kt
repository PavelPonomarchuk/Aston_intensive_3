package ru.ponomarchukpn.aston_intensive_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class ShowImageActivity : AppCompatActivity() {

    private val editTextUrl by bind<EditText>(R.id.images_edit_text, this)
    private val imageView by bind<ImageView>(R.id.images_image_view, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)
        listenEditText()
    }

    private fun listenEditText() {
        editTextUrl.doAfterTextChanged {
            showImage(it.toString())
        }
    }

    private fun showImage(stringUrl: String) {
        if (stringUrl.isBlank()) {
            return
        }
        Picasso.get()
            .load(stringUrl)
            .resize(targetImageWidthPx(), 0)
            .into(imageView, callback())
    }

    private fun callback() = object : Callback {
        override fun onSuccess() = Unit

        override fun onError(e: Exception?) {
            showErrorToast()
            Picasso.get().cancelRequest(imageView)
        }
    }

    private fun targetImageWidthPx(): Int {
        val imageWidthDp = resources.getDimension(R.dimen.images_image_view_width)
        return (resources.displayMetrics.density * imageWidthDp).toInt()
    }

    private fun showErrorToast() {
        val message = getString(R.string.images_error_message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newIntent(context: Context) = Intent(context, ShowImageActivity::class.java)
    }
}
