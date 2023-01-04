package com.example.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import com.example.instagram.databinding.ActivityMainBinding
import com.example.instagram.databinding.FragmentHome1Binding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment2 = Fragment2()
        val homeFragment1 = HomeFragment1()
        val fragmentManeger = supportFragmentManager

        fragmentManeger.beginTransaction()
            .add(R.id.my_container, homeFragment1)
            .commit()

        binding.tvMyProfile.setOnClickListener{
            fragmentManeger.beginTransaction()
                .replace(R.id.my_container, fragment2)
                .commit()
        }
        binding.tvHome.setOnClickListener{
            fragmentManeger.beginTransaction()
                .replace(R.id.my_container, homeFragment1)
                .commit()
        }
    }
}