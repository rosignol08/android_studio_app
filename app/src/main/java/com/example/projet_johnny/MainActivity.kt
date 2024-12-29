package com.example.projet_johnny

import android.media.MediaPlayer
import android.view.View
import android.animation.ObjectAnimator
import android.widget.ImageView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import kotlin.random.Random
import android.animation.AnimatorSet

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // Liste des fichiers sonores dans res/raw/
    val soundFiles = listOf(
        R.raw.besoin_toucher_voir, // Remplacez par vos fichiers réels
        R.raw.vraiment,
        R.raw.salut_cest_johny,
        R.raw.bonjour_johnny,
        R.raw.elle_a_ma_geule
    )
    // Fonction pour jouer un son aléatoire
    private fun playRandomSound() {
        val randomIndex = Random.nextInt(soundFiles.size) // Choisir un index aléatoire
        val soundResource = soundFiles[randomIndex] // Récupérer le son correspondant
        val mediaPlayer = MediaPlayer.create(this, soundResource) // Créer le MediaPlayer avec le son
        mediaPlayer.start() // Jouer le son
    }
    // Fonction pour positionner aléatoirement les stickers
    private fun positionAndShowStickers() {
        for (sticker in stickers) {
            val randomX = Random.nextInt(0, 800) // Position aléatoire sur X (changez selon la largeur de l'écran)
            val randomY = Random.nextInt(0, 600) // Position aléatoire sur Y (changez selon la hauteur de l'écran)
            sticker.x = randomX.toFloat()
            sticker.y = randomY.toFloat()
            sticker.visibility = View.VISIBLE // Assurez-vous que le sticker est visible
        }
    }

    // Fonction pour réinitialiser les stickers (nouvelle position et nouveau son)
    private fun resetStickers() {
        for (sticker in stickers) {
            sticker.clearAnimation() // Stoppe toute animation en cours
            sticker.rotation = 0f // Réinitialise la rotation
            sticker.translationY = 0f // Réinitialise la position Y
            sticker.visibility = View.VISIBLE // Assurez-vous que le sticker est visible
            // Réinitialiser la position aléatoire
            val randomX = Random.nextInt(0, 800)
            val randomY = Random.nextInt(0, 600)
            sticker.x = randomX.toFloat()
            sticker.y = randomY.toFloat()

        }
    }
    // Liste de stickers
    val stickers = mutableListOf<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stickerWidth = 200 // Taille en pixels
        val stickerHeight = 200 // Taille en pixels
        // Initialisation du ViewPager2
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        //initialisation des stickers
        stickers.add(findViewById(R.id.sticker1))
        stickers.add(findViewById(R.id.sticker2))
        stickers.add(findViewById(R.id.sticker3))
        stickers.add(findViewById(R.id.sticker4))
        stickers.add(findViewById(R.id.sticker5))
        // Obtenir la taille de l'écran
        val screenWidth = resources.displayMetrics.widthPixels
        val screenHeight = resources.displayMetrics.heightPixels
        for (sticker in stickers) {
            val layoutParams = sticker.layoutParams
            layoutParams.width = stickerWidth
            layoutParams.height = stickerHeight
            sticker.layoutParams = layoutParams
            val randomX = Random.nextInt(0, screenWidth - sticker.width) // Position X aléatoire
            val randomY = Random.nextInt(0, screenHeight - sticker.height) // Position Y aléatoire
            sticker.x = randomX.toFloat()
            sticker.y = randomY.toFloat()

            // Rendre le sticker visible
            sticker.visibility = View.VISIBLE
            // Détecter les clics sur l'image du sticker
            sticker.setOnClickListener {
                // Jouer le son au clic
                playRandomSound()

                // Créer l'animation de chute
                val fallDistance = 3000f  // La distance de chute (en pixels)
                val currentY = sticker.y  // La position actuelle du sticker (en pixels)

                // Calculer la durée de l'animation en fonction de la position y
                val fallDuration = ((screenHeight - currentY) / screenHeight * 1500).toLong().coerceAtLeast(500)

                // Créer l'animation avec une durée dynamique
                val fallAnimation = ObjectAnimator.ofFloat(sticker, "translationY", currentY, fallDistance)
                fallAnimation.duration = fallDuration.toLong()  // Durée en ms

                // Créer l'animation de rotation
                val rotationDirection = if (Math.random() > 0.5) 1 else -1 // Choisir une direction aléatoire (horaire ou antihoraire)
                val rotationAngle = (Math.random() * 540 + 180) * rotationDirection  // Angle de 180 à 720 degrés

                val rotateAnimation = ObjectAnimator.ofFloat(sticker, "rotation", 0f, rotationAngle.toFloat())
                rotateAnimation.duration = fallDuration.toLong()  // La même durée que la chute

                // Lancer les animations simultanément
                val animatorSet = AnimatorSet()
                animatorSet.playTogether(fallAnimation, rotateAnimation)
                animatorSet.start()

                // Optionnel : Cacher l'image à la fin de l'animation
                fallAnimation.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        if (animation != null) {
                            super.onAnimationEnd(animation)
                        }
                        sticker.visibility =
                            View.GONE  // Masquer le sticker une fois qu'il est tombé
                    }
                })
            }
        }
        // Initialiser le bouton pour réinitialiser les stickers
        val resetButton: ImageButton = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            resetStickers()
        }

        // Positionner et rendre visibles les stickers dès le départ
        positionAndShowStickers()

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
