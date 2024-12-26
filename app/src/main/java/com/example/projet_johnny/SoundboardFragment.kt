package com.example.projet_johnny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.util.DisplayMetrics

import android.media.MediaPlayer
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
//import androidx.compose.ui.semantics.text

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
        val buttonSound5: Button = view.findViewById(R.id.button_sound5)
        var buttonSound6: Button = view.findViewById(R.id.button_sound6)
        var buttonSound7: Button = view.findViewById(R.id.button_sound7)
        var buttonSound8: Button = view.findViewById(R.id.button_sound8)
        var buttonSound9: Button = view.findViewById(R.id.button_sound9)
        var buttonSound10: Button = view.findViewById(R.id.button_sound10)
        var buttonSound11: Button = view.findViewById(R.id.button_sound11)
        var buttonSound12: Button = view.findViewById(R.id.button_sound12)
        var buttonSound13: Button = view.findViewById(R.id.button_sound13)
        var buttonSound14: Button = view.findViewById(R.id.button_sound14)

        val gifImageView: ImageView = view.findViewById(R.id.gif_imageView)

        // Calcule la largeur de l'écran et la largeur des boutons
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val buttonWidth = (screenWidth / 3) - convertDpToPx(12, displayMetrics)
        // Applique la largeur calculée aux boutons
        val buttons = listOf(buttonSound1, buttonSound2, buttonSound3, buttonSound4, buttonSound5, buttonSound6, buttonSound7, buttonSound8, buttonSound9, buttonSound10, buttonSound11, buttonSound12, buttonSound13, buttonSound14)
        buttons.forEach { button ->
            val layoutParams = button.layoutParams
            layoutParams.width = buttonWidth
            button.layoutParams = layoutParams
        }

        // Bouton 1 : joue "sound1.mp3"
        buttonSound1.setOnClickListener {
            playSound(R.raw.elle_a_ma_geule)
            clicked(buttonSound1)
            Glide.with(this)
                .load(R.drawable.base_video)  //le fichier GIF
                .into(gifImageView)
        }

        // Bouton 2 : joue "sound2.mp3"
        buttonSound2.setOnClickListener {
            playSound(R.raw.houraken)
            clicked(buttonSound2)
            Glide.with(this)
                .load(R.drawable.dance)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 3 : joue "sound3.mp3"
        buttonSound3.setOnClickListener {
            playSound(R.raw.salut_cest_johny)
            clicked(buttonSound3)
            Glide.with(this)
                .load(R.drawable.pluie)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 4 : joue "sound4.mp3"
        buttonSound4.setOnClickListener {
            playSound(R.raw.bonjour_johnny)
            clicked(buttonSound4)
            Glide.with(this)
                .load(R.drawable.retire_lunettes)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 5 : joue "sound5.mp3"
        buttonSound5.setOnClickListener {
            playSound(R.raw.besoin_toucher_voir)
            clicked(buttonSound5)
            Glide.with(this)
                .load(R.drawable.agite)  //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 6 : joue "sound6.mp3"
        buttonSound6.setOnClickListener {
            playSound(R.raw.photos_truquee)
            clicked(buttonSound6)
            Glide.with(this)
                .load(R.drawable.motos_moche) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 7 : joue "sound7.mp3"
        buttonSound7.setOnClickListener {
            playSound(R.raw.vraiment)
            clicked(buttonSound7)
            Glide.with(this)
                .load(R.drawable.micro_dance) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 8 : joue "sound8.mp3"
        buttonSound8.setOnClickListener {
            playSound(R.raw.vraiment_cest_vrai)
            clicked(buttonSound8)
            Glide.with(this)
                .load(R.drawable.moche) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 9 : joue "sound9.mp3"
        buttonSound9.setOnClickListener {
            playSound(R.raw.une_seule_fois)
            clicked(buttonSound9)
            Glide.with(this)
                .load(R.drawable.moche2) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 10 : joue "sound10.mp3"
        buttonSound10.setOnClickListener {
            playSound(R.raw.ca_a_vraiment_existe)
            clicked(buttonSound10)
            Glide.with(this)
                .load(R.drawable.dance1) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 11 : joue "sound11.mp3"
        buttonSound11.setOnClickListener {
            playSound(R.raw.moquez_pas_de_moi)
            clicked(buttonSound11)
            Glide.with(this)
                .load(R.drawable.dance) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 12 : joue "sound12.mp3"
        buttonSound12.setOnClickListener {
            playSound(R.raw.plonger_mon_corps)
            clicked(buttonSound12)
            Glide.with(this)
                .load(R.drawable.bleu) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 13 : joue "sound13.mp3"
        buttonSound13.setOnClickListener {
            playSound(R.raw.quoi_ma_geule)
            clicked(buttonSound13)
            Glide.with(this)
                .load(R.drawable.retire_lunettes) //le fichier GIF
                .into(gifImageView)
        }
        // Bouton 14 : joue "sound14.mp3"
        buttonSound14.setOnClickListener {
            playSound(R.raw.elle_a_ma_geule_reverse)
            clicked(buttonSound14)
            Glide.with(this)
                .load(R.drawable.pluie) //le fichier GIF
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
    private fun convertDpToPx(dp: Int, displayMetrics: DisplayMetrics): Int {
        return (dp * displayMetrics.density).toInt()
    }

    fun clicked(button: Button) {
        //button.text = " "
        val reboundAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.rebond).apply {
            interpolator = MyBounceInterpolator(0.2, 20.0)
        }
        button.startAnimation(reboundAnimation)
    }
}
