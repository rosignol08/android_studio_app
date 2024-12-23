package com.example.projet_johnny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BiographyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Charge le même layout que dans l'activité
        return inflater.inflate(R.layout.activity_biography, container, false)
    }
}



//package com.example.projet_johnny

//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity

//class BiographyActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_biography)

        // Si tu veux ajouter des interactions ou charger dynamiquement des données,
        // tu peux le faire ici
    //}
//}
