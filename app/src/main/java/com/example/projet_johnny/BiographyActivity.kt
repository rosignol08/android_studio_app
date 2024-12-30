package com.example.projet_johnny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment

class BiographyFragment : Fragment() {
    private var imageYoung: ImageView? = null
    private var imageMiddle: ImageView? = null
    private var imageOld: ImageView? = null
    private var scrollView: NestedScrollView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_biography, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialisation des vues avec les IDs corrects de votre layout
        imageYoung = view.findViewById(R.id.image_johnny_jeune)
        imageMiddle = view.findViewById(R.id.image_johnny_halliday_tete)
        imageOld = view.findViewById(R.id.image_johnny_vieux)
        scrollView = view.findViewById(R.id.scrollView)

        // Gestion du scroll
        scrollView?.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, _, scrollY, _, _ ->
            // Calculer la hauteur totale scrollable
            val scrollViewHeight = v.height
            val totalScrollHeight = v.getChildAt(0).height - scrollViewHeight

            // Éviter la division par zéro
            if (totalScrollHeight <= 0) return@OnScrollChangeListener

            // Calculer le pourcentage de scroll
            val scrollPercentage = scrollY.toFloat() / totalScrollHeight.toFloat()

            // Gérer les transitions d'images
            when {
                scrollPercentage <= 0.3f -> {
                    // Transition de young à middle
                    val progress = (scrollPercentage / 0.3f)
                    imageYoung?.alpha = 1f - progress
                    imageMiddle?.alpha = progress
                    imageOld?.alpha = 0f
                }
                scrollPercentage <= 0.6f -> {
                    // Transition de middle à old
                    val progress = ((scrollPercentage - 0.3f) / 0.3f)
                    imageYoung?.alpha = 0f
                    imageMiddle?.alpha = 1f - progress
                    imageOld?.alpha = progress
                }
                else -> {
                    // Image finale (old)
                    imageYoung?.alpha = 0f
                    imageMiddle?.alpha = 0f
                    imageOld?.alpha = 1f
                }
            }
        })
    }
}