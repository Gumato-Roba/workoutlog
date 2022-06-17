package dev.gumato.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.gumato.workoutlog.databinding.ActivityHomepageBinding
import dev.gumato.workoutlog.databinding.ActivityLoginBinding

class HomepageActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
}