package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val GET_CHANGE = 1

    private var balance = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        value_display.text = "$balance"

    }

    fun navToChangeActivity(view: View) {
        val i: Intent = Intent(this, ChangeActivity::class.java)
        startActivityForResult(i, GET_CHANGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_CHANGE) {
            Log.d("GOT CHANGE", data.toString())
            if (resultCode == Activity.RESULT_OK) {
                val isDeposit = data?.extras?.getBoolean("isDeposit")
                val amount = data?.extras?.getInt("value")
                if (isDeposit != null && amount != null) {
                    if (isDeposit) {
                        balance += amount
                    } else {
                        balance -= amount
                    }
                    value_display.text = "$balance"
                }

            }
        }
    }

}
