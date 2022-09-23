package dev.gumato.workoutlog.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dev.gumato.workoutlog.api.ApiClient
import dev.gumato.workoutlog.api.ApiInterface
import dev.gumato.workoutlog.databinding.ActivitySignupBinding
import dev.gumato.workoutlog.models.RegisterRequest
import dev.gumato.workoutlog.models.RegisterResponse
import dev.gumato.workoutlog.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castView()


    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerResponse ->
                Toast.makeText(baseContext, registerResponse.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, LoginActivity::class.java))
            })
        userViewModel.registerErrorLiveData.observe(
            this,
            androidx.lifecycle.Observer { registerError ->
                Toast.makeText(baseContext, registerError, Toast.LENGTH_LONG).show()
            })
    }
    fun castView(){
        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvLogin.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun validateSignup(){
        var error = false
       binding.tilFirstName.error = null
        binding.tilLastName.error = null
        var firstName = binding.etFirstName.text.toString()
        var lastName = binding.etLastName.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()
        var email = binding.etPassword.text.toString()
        var password = binding.etPassword2.text.toString()
        var confirm = binding.etConfirm.text.toString()

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "Enter your first name"

        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Enter your last name"
        }

        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Enter your phone number"

        }
        if (email.isBlank()) {
            binding.tilPassword.error = "Enter your email"

        }
//        if (Pattern.EMAIL_ADDRESS.matcher(email).matches()){
//            binding.til.error = "Invalid"
//            error=true
//        }
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
            var intent=Intent(this, HomepageActivity::class.java)
            startActivity(intent)

        }
        if(!error){
            val registerRequest = RegisterRequest(firstName, lastName,phoneNumber,email,password,)
            userViewModel.registerUser(registerRequest)
        }
    }

    }


