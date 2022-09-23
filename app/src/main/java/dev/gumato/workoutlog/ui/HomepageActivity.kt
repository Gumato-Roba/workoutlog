package dev.gumato.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.gumato.workoutlog.R
import dev.gumato.workoutlog.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    lateinit var sharePrefs: SharedPreferences
    lateinit var tvLogout: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvLogout = findViewById(R.id.tvLogout)
        tvLogout.setOnClickListener {
            val editor=sharePrefs.edit()
            editor.putString("ACCESS_TOKEN","")
            editor.putString("USER_ID","")
            editor.putString("PROFILE_ID","")
            editor.apply()
            startActivity(Intent(this,LoginActivity::class.java))
            logoutRequest()
        }
        castViews()
        setupBottomNav()
    }fun castViews(){
    }
    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.plan ->{
                     supportFragmentManager.beginTransaction().replace(R.id.bottomNavigation, PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                     supportFragmentManager.beginTransaction().replace(R.id.bottomNavigation, TrackFragment()).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(R.id.bottomNavigation, ProfileFragment()).commit()
                    true
                }
                else->false
            }
        }

    }
    fun logoutRequest(){
        sharePrefs.edit().clear().commit()
    }

}