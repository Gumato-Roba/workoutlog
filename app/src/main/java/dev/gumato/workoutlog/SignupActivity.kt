package dev.gumato.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tilFirstName: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilEmail2: TextInputLayout
    lateinit var etEmail2: TextInputEditText
    lateinit var tilPassword2: TextInputLayout
    lateinit var etPassword2: TextInputEditText
    lateinit var tilConfirm: TextInputLayout
    lateinit var etConfirm: TextInputEditText
    lateinit var btnSignup:Button
    lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        castView()
    }
    fun castView(){
        tilFirstName= findViewById(R.id.tilFirstName)
        etFirstName= findViewById(R.id.etFirstName)
        tilLastName= findViewById(R.id.tilLastName)
        etLastName= findViewById(R.id.etLastName)
        tilEmail2= findViewById(R.id.tilEmail2)
        etEmail2= findViewById(R.id.etEmail2)
        tilPassword2= findViewById(R.id.tilPassword2)
        etPassword2= findViewById(R.id.etPassword2)
        tilConfirm= findViewById(R.id.tilConfirm)
        etConfirm= findViewById(R.id.etConfirm)
        btnSignup= findViewById(R.id.btnSignup)
        tvLogin= findViewById(R.id.tvLogin)

        btnSignup.setOnClickListener {
            validateSignup()
        }
        tvLogin.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSignup(){
        var error = true
        tilFirstName.error = null
        var firstName = etFirstName.text.toString()
        var lastName = etLastName.text.toString()
        var email = etEmail2.text.toString()
        var password = etPassword2.text.toString()
        var confirm = etConfirm.text.toString()

        if (firstName.isBlank()) {
            tilFirstName.error = "Enter your first name"

        }
        if (lastName.isBlank()) {
            tilLastName.error = "Enter your last name"
        }
        if (email.isBlank()) {
            tilEmail2.error = "Enter your email"

        }
        if (password.isBlank()) {
            tilPassword2.error = "Enter your password"
        }
        if (confirm.isBlank()) {
            tilConfirm.error = "Confirm your password"
        }
        if(password!=confirm){
            tilPassword2.error="Password does not match"
        }
        if (!error){
            var intent=Intent(this,HomepageActivity::class.java)
            startActivity(intent)

        }
    }
    }

