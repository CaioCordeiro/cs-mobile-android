package com.cesarschool.newapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nova.*

class NovaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova)
        val name  = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_NAME_EXTRA_ID)

        val myCar = intent.getParcelableExtra<Car>(MainActivity.MAIN_ACTIVITY_CAR_EXTRA_ID)
//        val result = getString(R.string.second_activity_message,name,myCar?.nome)

        textViewName.text = getString(R.string.second_activity_message, name, myCar?.nome)
    }
}