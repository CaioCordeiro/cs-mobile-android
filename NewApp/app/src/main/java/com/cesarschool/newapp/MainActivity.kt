package com.cesarschool.newapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    companion object {
        const val MAIN_ACTIVITY_NAME_EXTRA_ID = "name"
        const val MAIN_ACTIVITY_CAR_EXTRA_ID = "car"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button2.setOnClickListener {
            mainActivityTextView.setText("Gados: "+ count++)
        }
        mainActivitybutton.setOnClickListener {
            val name = textPersonName.text.toString()
            if(isNameValid(name)) {
                val novaActivity = Intent(this, NovaActivity::class.java)
                novaActivity.putExtra(MAIN_ACTIVITY_NAME_EXTRA_ID, name)

                val myCar = Car("Gol", "Teste", 2020)
                novaActivity.putExtra(MAIN_ACTIVITY_CAR_EXTRA_ID, myCar)

                startActivity(novaActivity)
            }else{
                Toast.makeText(this, "Please fill your name", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun isNameValid(name: String ): Boolean = !name.isNullOrEmpty()
}