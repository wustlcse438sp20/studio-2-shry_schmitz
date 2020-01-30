package com.example.studio2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_change.*
import kotlinx.android.synthetic.main.fragment_deposit.*
import kotlinx.android.synthetic.main.fragment_withdraw.*

class ChangeActivity : AppCompatActivity() {

    var isDeposit = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

    }

    override fun onStart() {
        super.onStart()

        val fragment = DepositFragment()
        //var bundle = Bundle()

        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.contaner, fragment)
        trans.commit()
    }

    fun returnWithdraw(view: View) {
        val result = Intent()
        result.putExtra("isDeposit", false)
        result.putExtra("value", withdraw_value.text.toString().toInt())
        setResult(Activity.RESULT_OK, result)
        finish();
    }

    fun returnDeposit(view: View) {
        val result = Intent()
        result.putExtra("isDeposit", true)
        result.putExtra("value", deposit_value.text.toString().toInt())
        setResult(Activity.RESULT_OK, result)
        finish();
    }

    fun changeFragment(view: View) {
        if (!isDeposit) {
            val fragment = DepositFragment()
            //var bundle = Bundle()

            val trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.contaner, fragment)
            trans.commit()
        } else {
            val fragment = WithdrawFragment()
            //var bundle = Bundle()

            val trans = supportFragmentManager.beginTransaction()
            trans.replace(R.id.contaner, fragment)
            trans.commit()
        }
        isDeposit = !isDeposit
    }

}
