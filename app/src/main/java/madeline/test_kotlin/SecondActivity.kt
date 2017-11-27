package madeline.test_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    private var isFragmentOneLoaded = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val Change = findViewById<Button>(R.id.btn_change)
        ShowFragment(FragmentOne())
        Change.setOnClickListener({
            isFragmentOneLoaded = if (isFragmentOneLoaded) {
                ShowFragment(FragmentTwo())
                false
            } else {
                ShowFragment(FragmentOne())
                true
            }
        })
    }
    private fun ShowFragment(frag: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_holder, frag)
        //        transaction.addToBackStack(null)
        transaction.commit()
    }
}
