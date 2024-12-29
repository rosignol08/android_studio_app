package com.example.projet_johnny

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // Configuration de l'adaptateur
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }
        // Lier le TabLayout au ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Exemple de personnalisation avec du texte
            when (position) {
                0 -> {
                    tab.text = "Biographie"
                    tab.icon = getDrawable(R.drawable.ic_biography) // Exemple d'icône
                }
                1 -> {
                    tab.text = "Soundboard"
                    tab.icon = getDrawable(R.drawable.ic_soundboard) // Exemple d'icône
                }
            }
        }.attach()
    }
}
