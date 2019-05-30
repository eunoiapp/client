package eunoiapp.app

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val EUNOIAPP_NAME_KEY = "EUNOIAPP_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNameClick(v: View) {
        val text = findViewById<TextView>(R.id.name_text).text
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(EUNOIAPP_NAME_KEY, text.toString())
    }
}
