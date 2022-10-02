package com.cooki.colourcloud.ui.homePage

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cooki.colourcloud.R
import com.cooki.colourcloud.TAG
import com.cooki.colourcloud.mastah
import com.cooki.colourcloud.ui.paletteStudio.PaletteStudio

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var barPaletteColour1: AppCompatButton
    private lateinit var barPaletteColour2: AppCompatButton
    private lateinit var barPaletteColour3: AppCompatButton
    private lateinit var barPaletteColour4: AppCompatButton
    private lateinit var barPaletteColour5: AppCompatButton
    private lateinit var btnLikePalette: AppCompatButton
    private lateinit var iconLike: View
    private lateinit var iconLiked: View
    private lateinit var btnSavePalette: AppCompatButton
    private lateinit var iconSave: View
    private lateinit var iconSaved: View
    private lateinit var btnTagPalette: AppCompatButton
    private lateinit var iconTag: View
    private lateinit var iconTags: View
    private lateinit var iconRandomizePalette: View
    private lateinit var iconModifyPalette: View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        barPaletteColour1 = root.findViewById(R.id.barPaletteColour1)
        barPaletteColour2 = root.findViewById(R.id.barPaletteColour2)
        barPaletteColour3 = root.findViewById(R.id.barPaletteColour3)
        barPaletteColour4 = root.findViewById(R.id.barPaletteColour4)
        barPaletteColour5 = root.findViewById(R.id.barPaletteColour5)
        btnLikePalette = root.findViewById(R.id.btnLikePalette)
        iconLike = root.findViewById(R.id.iconLike)
        iconLiked = root.findViewById(R.id.iconLiked)
        btnSavePalette = root.findViewById(R.id.btnSavePalette)
        iconSave = root.findViewById(R.id.iconSave)
        iconSaved = root.findViewById(R.id.iconSaved)
        btnTagPalette = root.findViewById(R.id.btnTagPalette)
        iconTag = root.findViewById(R.id.iconTag)
        iconTags = root.findViewById(R.id.iconTags)
        iconRandomizePalette = root.findViewById(R.id.iconRandomizePalette)
        iconModifyPalette = root.findViewById(R.id.iconModifyPalette)

        //clickable
        iconRandomizePalette.setOnClickListener { randomizePalette() }

        btnLikePalette.setOnClickListener{ updateLikePalette() }
        btnSavePalette.setOnClickListener{ updateSavePalette() }
        btnTagPalette.setOnClickListener{ updateTagPalette() }

        iconModifyPalette.setOnClickListener{ openPaletteStudio() }

        return root
    }

    private fun openPaletteStudio(){
        val intent : Intent = Intent(activity, PaletteStudio::class.java)
        startActivity(intent)
    }
    private fun randomizePalette(){
        //grab random palette (function that just returns palette colours, below is just a sample
        var rng = (0..7).random()
        //var palette:Array<Long> = mastah[rng]
        //var p2: Array<Long> = arrayOf(0xFF03DAC5, 0xFF018786, 0xFF3F51B5, 0xFF6200EE, 0xFFBB86FC)
        //Log.i(TAG, "btdubs the first colour is ${palette[0].toInt()} ")
        //update on click
        barPaletteColour1.setBackgroundTintList(ColorStateList.valueOf(mastah[rng][0].toInt()))
        barPaletteColour2.setBackgroundTintList(ColorStateList.valueOf(mastah[rng][1].toInt()))
        barPaletteColour3.setBackgroundTintList(ColorStateList.valueOf(mastah[rng][2].toInt()))
        barPaletteColour4.setBackgroundTintList(ColorStateList.valueOf(mastah[rng][3].toInt()))
        barPaletteColour5.setBackgroundTintList(ColorStateList.valueOf(mastah[rng][4].toInt()))
    }

    private fun updateLikePalette(){
        if(iconLike.isVisible){ //like
            iconLike.visibility = View.INVISIBLE
            iconLiked.visibility = View.VISIBLE
        }
        else if (iconLiked.isVisible){ //unlike
            Log.i(TAG, "UNLIKING")
            iconLike.visibility = View.VISIBLE
            iconLiked.visibility = View.INVISIBLE
        }
    }
    private fun updateSavePalette(){
        if(iconSave.isVisible){ //like
            Log.i(TAG, "save!")
            iconSave.visibility = View.INVISIBLE
            iconSaved.visibility = View.VISIBLE
        }
        else if (iconSaved.isVisible){ //unlike
            Log.i(TAG, "UNsaving!")
            iconSave.visibility = View.VISIBLE
            iconSaved.visibility = View.INVISIBLE
        }
    }

    private fun updateTagPalette(){
        if(iconTag.isVisible){ //like
            Log.i(TAG, "open tags!")
            iconTag.visibility = View.INVISIBLE
            iconTags.visibility = View.VISIBLE
        }
        else if (iconTags.isVisible){ //unlike
            Log.i(TAG, "close them!")
            iconTag.visibility = View.VISIBLE
            iconTags.visibility = View.INVISIBLE
        }
    }
}