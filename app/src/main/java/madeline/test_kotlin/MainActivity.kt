package madeline.test_kotlin

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.Button
import android.widget.Toast
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener {
//            Toast.makeText(this@MainActivity, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
            doAsync {
                var result = LocalDateTime.now().toString()
                uiThread {
                    toast(result)
                }
            }
        }

        val button2: Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)

            startActivity(randomIntent)
        }

        val button_alert: Button = findViewById(R.id.button_alert)

        button_alert.setOnClickListener {
            alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
                yesButton { toast("Oh…") }
                noButton {}
            }.show()
        }
    }
}
