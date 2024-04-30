package com.example.srwa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.srwa.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //DEKLARASI
    lateinit var textFullName: TextView
    lateinit var textEmail: TextView

    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //INISIALISASI
        textFullName = findViewById(R.id.full_name)
        textEmail = findViewById(R.id.email)

        val firebaseuser = firebaseAuth.currentUser
        if (firebaseuser!=null){
            textFullName.text = firebaseuser.displayName
            textEmail.text = firebaseuser.email
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}