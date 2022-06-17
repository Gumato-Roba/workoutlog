package dev.gumato.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.gumato.workoutlog.databinding.ActivityLoginBinding
import dev.gumato.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,HomepageActivity::class.java)
            startActivity(intent)
        }

    }
    fun castView(){
        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvLogin.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSignup(){
        var error = true
       binding.tilFirstName.error = null
        var firstName = binding.etFirstName.text.toString()
        var lastName = binding.etLastName.text.toString()
        var email = binding.etPassword.text.toString()
        var password = binding.etPassword2.text.toString()
        var confirm = binding.etConfirm.text.toString()

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "Enter your first name"

        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Enter your last name"
        }
        if (email.isBlank()) {
            binding.tilPassword.error = "Enter your email"

        }
        if (password.isBlank()) {
            binding.tilPassword2.error = "Enter your password"
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm your password"
        }
        if(password!=confirm){
            binding.tilPassword2.error="Password does not match"
        }
        if (!error){
            var intent=Intent(this,HomepageActivity::class.java)
            startActivity(intent)

        }
    }
    }

