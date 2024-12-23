package com.example.projet_johnny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageView

import com.bumptech.glide.Glide //pour les gif ça


class SoundboardFragment : Fragment(R.layout.fragment_soundboard) {

    private var mediaPlayer: MediaPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configure les boutons
        val buttonSound1: Button = view.findViewById(R.id.button_sound1)
        val buttonSound2: Button = view.findViewById(R.id.button_sound2)
        val buttonSound3: Button = view.findViewById(R.id.button_sound3)
        val buttonSound4: Button = view.findViewById(R.id.button_sound4)
        val gifImageView: ImageView = view.findViewById(R.id.gif_imageView)



        // Bouton 1 : joue "sound1.mp3"
        buttonSound1.setOnClickListener {
            playSound(R.raw.elle_a_ma_geule)
            Glide.with(this)
                .load(R.drawable.test1gif)  //le fichier GIF
                .into(gifImageView)
        }

        // Bouton 2 : joue "sound2.mp3"
        buttonSound2.setOnClickListener {
            playSound(R.raw.houraken)
            Glide.with(this)
                .load(R.drawable.dance)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 3 : joue "sound3.mp3"
        buttonSound3.setOnClickListener {
            playSound(R.raw.salut_cest_johny)
            Glide.with(this)
                .load(R.drawable.pluie)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 4 : joue "sound4.mp3"
        buttonSound4.setOnClickListener {
            playSound(R.raw.bonjour_johnny)
            Glide.with(this)
                .load(R.drawable.retire_lunettes)  //le fichier GIF
                .into(gifImageView)
        }
    }

    private fun playSound(soundResId: Int) {
        // Libère le MediaPlayer précédent (si actif)
        mediaPlayer?.release()

        // Initialise et démarre un nouveau MediaPlayer
        mediaPlayer = MediaPlayer.create(context, soundResId)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Libère le MediaPlayer quand le fragment est détruit
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
