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

        val change = findViewById<Button>(R.id.btn_change)
        showFragment(FragmentOne())
        change.setOnClickListener({
            isFragmentOneLoaded = if (isFragmentOneLoaded) {
                showFragment(FragmentTwo())
                false
            } else {
                showFragment(FragmentOne())
                true
            }
        })
    }
    private fun showFragment(frag: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_holder, frag)
        //        transaction.addToBackStack(null)
        transaction.commit()
    }
}
