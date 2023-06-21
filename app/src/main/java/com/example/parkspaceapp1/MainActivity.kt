package com.example.parkspaceapp1

import android.app.Dialog
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signupbutton =findViewById<Button>(R.id.button_signup)
        val loginbutton =findViewById<Button>(R.id.button_login)

        signupbutton.setOnClickListener {
            val intent=Intent(this,Signupactivity::class.java)
            startActivity(intent) }
        loginbutton.setOnClickListener{
            val intent=Intent(this,login::class.java)
           startActivity(intent)
        }
        NetworkTask(this).execute()

    }
    class NetworkTask(var activity:MainActivity): AsyncTask<Void, Void, Void>() {
        var dialog = Dialog(activity,android.R.style.Theme_Translucent_NoTitleBar)
        override fun onPreExecute() {
            val view=activity.layoutInflater.inflate(R.layout.progressphase,null)
            dialog.setContentView(view )
            dialog.setCancelable(false)
            dialog.show()
            super.onPreExecute()
        }
        override fun doInBackground(vararg params: Void?): Void? {
            Thread.sleep(2000)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            dialog.dismiss()
        }
    }
}