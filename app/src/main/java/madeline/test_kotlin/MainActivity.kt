package madeline.test_kotlin

import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.Toast
import org.jetbrains.anko.*
import java.time.LocalDateTime
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button2: Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            val fragIntent = Intent(this, SecondActivity::class.java)
            startActivity(fragIntent)
        }

        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener {
            // Anko async
            doAsync {
                var result = LocalDateTime.now().toString()
                uiThread {
                    // Anko toast
                    toast(result)
                    // Native toast
                    // Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val button_alert: Button = findViewById(R.id.button_alert)

        button_alert.setOnClickListener {
            // Anko alert
            alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
                yesButton { toast("Oh…") }
                noButton {}
            }.show()
            // Native Alert
//            val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
//            simpleAlert.setTitle("Alert")
//            simpleAlert.setMessage("Show simple Alert")
//
//            simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", {
//                dialogInterface, i ->
//                Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show()
//            })
//
//            simpleAlert.show()
        }

        val button3: Button = findViewById(R.id.button3)

        button3.setOnClickListener {
            val editText: EditText = findViewById(R.id.editText)
            val textView: TextView = findViewById(R.id.textView)
            textView.text = editText.text
        }

        val button_geo: Button = findViewById(R.id.geo_button)

        button_geo.setOnClickListener {
//            val textView: TextView = findViewById(R.id.textView)
//            textView.text =
            }
        }
    }
