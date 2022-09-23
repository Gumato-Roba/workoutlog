package dev.gumato.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.gumato.workoutlog.api.ApiClient
import dev.gumato.workoutlog.api.ApiInterface
import dev.gumato.workoutlog.databinding.ActivityLoginBinding
import dev.gumato.workoutlog.models.LoginRequest
import dev.gumato.workoutlog.models.LoginResponse
import dev.gumato.workoutlog.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
   lateinit var binding: ActivityLoginBinding
   lateinit var sharedPrefs: SharedPreferences
   val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()
        sharedPrefs = getSharedPreferences("WORKOUT_LOG_PREFS", MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message, Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext, HomepageActivity::class.java))
        })
        userViewModel.errorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(this, errorMessage,Toast.LENGTH_LONG).show()

        })
    }

    fun castView() {
        binding.btnLogin.setOnClickListener {
            validateLogin()
             }
        binding.tvSignup.setOnClickListener {
            val intent=Intent(this, SignupActivity::class.java)
            startActivity(intent)

        }
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
            var intent=Intent(this, HomepageActivity::class.java)
                startActivity(intent)
        }
        if (!error){
            val loginRequest = LoginRequest(email, password)
            binding.pblogin.visibility = View.GONE
            userViewModel.loginUser(loginRequest)
        }
    }


    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor = sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()
    }
}