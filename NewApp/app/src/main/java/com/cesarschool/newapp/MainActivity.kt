package com.cesarschool.newapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    companion object {
        const val MAIN_ACTIVITY_NAME_EXTRA_ID = "name"
        const val MAIN_ACTIVITY_CAR_EXTRA_ID = "car"
        const val MAIN_ACTIVITY_EXTRA_NUMBER1 = "n1"
        const val MAIN_ACTIVITY_EXTRA_NUMBER2 = "n2"
        const val MAIN_ACTIVITY_EXTRA_SUM_ID = "sum"
        const val MAIN_ACTIVITY_SUM_RESULT_CODE = 1
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
        buttonAlarm.setOnClickListener {
            val message = editTextTextName.text.toString()
            val hour = editTextTextHour.text.toString()
            val minute = editTextTextMinutes.text.toString()
            createAlarm(message, hour.toInt(), minute.toInt())
        }
        buttonOk.setOnClickListener{
            var terceiraActivityIntent = Intent(this, TerceiraActivity::class.java)
            val valor1 = editTextNumber1.text.toString()
            val valor2 = editTextNumber2.text.toString()
            terceiraActivityIntent.putExtra(MAIN_ACTIVITY_EXTRA_NUMBER1, valor1)
            terceiraActivityIntent.putExtra(MAIN_ACTIVITY_EXTRA_NUMBER2, valor2)
            startActivityForResult(terceiraActivityIntent, MAIN_ACTIVITY_SUM_RESULT_CODE)
        }
    }
    private fun createAlarm(mensagem: String, hora: Int, minutos: Int) {
        val intentAlarme = Intent(AlarmClock.ACTION_SET_ALARM)
        intentAlarme.putExtra(AlarmClock.EXTRA_MESSAGE, mensagem)
        intentAlarme.putExtra(AlarmClock.EXTRA_HOUR, hora)
        intentAlarme.putExtra(AlarmClock.EXTRA_MESSAGE, minutos)

        if (intentAlarme.resolveActivity(packageManager) != null ) {
            startActivity(intentAlarme)
        } else {
            Toast.makeText(this, "Não foi encontrado uma activity para o intent filter escolhido", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            if(MAIN_ACTIVITY_SUM_RESULT_CODE == requestCode) {
                var result = data?.getStringExtra(MAIN_ACTIVITY_EXTRA_SUM_ID)
                Toast.makeText(this, "RESULTADO: $result ", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isNameValid(name: String ): Boolean = !name.isNullOrEmpty()
}