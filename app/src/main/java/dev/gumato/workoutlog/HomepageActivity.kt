package dev.gumato.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomepageActivity : AppCompatActivity() {
    lateinit var bnvHome: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        castViews()
        setupBottomNav()
    }fun castViews(){
        bnvHome= findViewById(R.id.bottomNavigation)
        fcvHome= findViewById(R.id.fcvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener { item ->
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