package com.example.projet_johnny

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation du ViewPager2
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragments: List<Fragment> = listOf(
            BiographyFragment(),  // La biographie
            SoundboardFragment()  // La soundboard
        )

        // Configuration de l'adaptateur
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }
    }
}
