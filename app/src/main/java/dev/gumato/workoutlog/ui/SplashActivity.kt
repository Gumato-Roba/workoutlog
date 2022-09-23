package dev.gumato.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("WORKOUT_LOG_PREFS", MODE_PRIVATE)

        val accessToken = sharedPrefs.getString("ACCESS_TOKEN", "")
        if (accessToken!!.isBlank()) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        else{
            startActivity(Intent(this, HomepageActivity::class.java))
        }
    }
}