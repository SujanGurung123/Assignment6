package com.example.esoftwarica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.esoftwarica.fragments.HomeFragment
import javax.microedition.khronos.egl.EGLDisplay

class LoginActivity : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pass: EditText
    private lateinit var btnlogin: Button

    var username = "softwarica"
    var password = "coventry"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        uname = findViewById(R.id.uname)
        pass = findViewById(R.id.pass)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            var inputuname = uname.text.toString()
            var inputpass = pass.text.toString()

            val intent = Intent(this, MainActivity::class.java)

            if (inputuname.isEmpty() && inputpass.isEmpty()){
                Toast.makeText(this,"Fields can't be left empty.", Toast.LENGTH_SHORT).show()
            }
            else {
                if (inputuname.equals(username) && inputpass.equals(password)) {
                    startActivity(intent)
                }
                else{
                    var tesst = "Login fail"
                    Toast.makeText(this, tesst, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}