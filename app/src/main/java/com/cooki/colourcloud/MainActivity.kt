package com.cooki.colourcloud

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


const val TAG = "MainActivity"

//private var palettes: Array<PaletteModel> = arrayOf(PaletteModel)
val mastah: Array<Array<Long>> = arrayOf(
    arrayOf(4293543627, 4293877142, 4294211706, 4294353791, 4294900615),
    arrayOf(4278442693, 4278290310, 4281794739, 4284612846, 4290479868),
    arrayOf(4292592335, 4288651954, 4282153609, 4281222998, 4279641646),
    arrayOf(4290695412, 4287342313, 4286486212, 4292327356, 4294436064),
    arrayOf(4290322464, 4294732055, 4294946856, 4282468882, 4283858007),
    arrayOf(4289914580, 4286578731, 4291586184, 4294935211, 4294945479),
    arrayOf(4285592816, 4294242918, 4294192555, 4294192620, 4294934111),
    arrayOf(4285563723, 4280367616, 4282740033, 4288260706, 4282541824)
    )

class MainActivity : AppCompatActivity() {

    /*
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
    */

    //private lateinit var iconlike: AppCompatImageView
    //private lateinit var db: DatabaseReference
    //private lateinit var palettelist: ArrayList<PaletteModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_saved, R.id.navigation_search))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        /*
        barPaletteColour1 = findViewById(R.id.barPaletteColour1)
        barPaletteColour2 = findViewById(R.id.barPaletteColour2)
        barPaletteColour3 = findViewById(R.id.barPaletteColour3)
        barPaletteColour4 = findViewById(R.id.barPaletteColour4)
        barPaletteColour5 = findViewById(R.id.barPaletteColour5)
        btnLikePalette = findViewById(R.id.btnLikePalette)
        iconLike = findViewById(R.id.iconLike)
        iconLiked = findViewById(R.id.iconLiked)
        btnSavePalette = findViewById(R.id.btnSavePalette)
        iconSave = findViewById(R.id.iconSave)
        iconSaved = findViewById(R.id.iconSaved)
        btnTagPalette = findViewById(R.id.btnTagPalette)
        iconTag = findViewById(R.id.iconTag)
        iconTags = findViewById(R.id.iconTags)
        iconRandomizePalette = findViewById(R.id.iconRandomizePalette)
        iconModifyPalette = findViewById(R.id.iconModifyPalette)

        //clickable
        iconRandomizePalette.setOnClickListener { randomizePalette() }

        btnLikePalette.setOnClickListener{ updateLikePalette() }
        btnSavePalette.setOnClickListener{ updateSavePalette() }
        btnTagPalette.setOnClickListener{ updateTagPalette() }
         */


        //db = FirebaseDatabase.getInstance().getReference("Palettes")
        //val plist = Array<PaletteModel>()
        //db.child("Palettes") Log.i(TAG,  "database isss ${db.database}")
        //palettelist = arrayListOf<PaletteModel>()

        //getData2()

    }

    private fun getData2(){
        /*
        Log.i(TAG, "AHAHAHAHA entering the get data function")
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //var id = snapshot.child("id").getValue()
                //Log.i(TAG, "heyheyhey id is $id")
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        val data = snap.getValue(PaletteModel::class.java)
                        palettelist.add(data!!)
                        Log.i(TAG, "ZEEEE Value is: $data")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i(TAG, "on cancelled function", error.toException())
            }
        })
        Log.i(TAG, "AHAHAHAHA leaving the get data function")
         */
    }
    /*
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
     */

    /*private fun getPalette(n: Int): Array<Long> {
        //val palette
        //val n = 2
        var masterlist: Array<Array<Long>> = arrayOf(
            arrayOf(4293543627, 4293877142, 4294211706, 4294353791, 4294900615),
            arrayOf(4278442693, 4278290310, 4281794739, 4284612846, 4290479868),
            arrayOf(4292592335, 4288651954, 4282153609, 4281222998, 4279641646),
            arrayOf(4290695412, 4287342313, 4286486212, 4292327356, 4294436064),
            arrayOf(4290322464, 4294732055, 4294946856, 4282468882, 4283858007),
            arrayOf(4289914580, 4286578731, 4291586184, 4294935211, 4294945479),
            arrayOf(4285592816, 4294242918, 4294192555, 4294192620, 4294934111),
            arrayOf(4285563723, 4280367616, 4282740033, 4288260706, 4282541824)
        )
        return masterlist[n]
    }
     */
}