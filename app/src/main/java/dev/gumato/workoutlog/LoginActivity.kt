package dev.gumato.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.gumato.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
   lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        binding.tvSignup.setOnClickListener {
            val intent=Intent(this,HomepageActivity::class.java)
            startActivity(intent)
        }
    }

    fun castView() {
        binding.btnLogin.setOnClickListener {
            validateLogin() }
    }

    fun validateLogin() {
        var error = false

        binding.tilEmail.error = null
        binding.tilPassword.error = null
        var email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            binding.tilEmail.error = "Enter your email"

        }
        var password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            binding.etPassword.error = "Enter your password"
        }
        if (!error) {
            var intent=Intent(this,HomepageActivity::class.java)
                startActivity(intent)

        }
    }
}