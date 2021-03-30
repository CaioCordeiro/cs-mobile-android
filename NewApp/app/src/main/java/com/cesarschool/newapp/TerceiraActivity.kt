package com.cesarschool.newapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_terceira.*

class TerceiraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terceira)
        val value01 = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_NUMBER1)
        val value02 = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_NUMBER2)

        if (value01 != null && value02 != null) {
            textView2.text = sumValues(value01.toDouble(), value02.toDouble()).toString()
        }

        buttonResult.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(MainActivity.MAIN_ACTIVITY_EXTRA_SUM_ID, textView2.text)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
    private fun sumValues(value01: Double, value02: Double) = value01 + value02
}
