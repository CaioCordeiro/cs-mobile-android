package com.cesarschool.newapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            mainActivityTextView.setText("Cornos: "+ count++)
        }
        mainActivitybutton.setOnClickListener {
            val novaActivity = Intent(this, NovaActivity::class.java)
            startActivity(novaActivity)
//            mainActivityTextView.setText(""+ count++)
        }

    }
}