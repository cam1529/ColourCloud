package com.cooki.colourcloud.ui.paletteStudio

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cooki.colourcloud.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PaletteStudio : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palette_studio)

        val tabLayout: TabLayout = findViewById(R.id.tabToolbar)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_ps_build_circle_48)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_ps_photo_camera_back_48)
                }
                2 -> {
                    tab.setIcon(R.drawable.ic_ps_baseline_bookmarks_48)
                }
                3 -> {
                    tab.setIcon(R.drawable.ic_ps_auto_awesome_48)
                }
            }
        }.attach()

    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 4

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    return ToolColourWheelFragment()
                }
                1 -> {
                    return ToolCameraFragment()
                }
                2 -> {
                    return ToolCollectionsFragment()
                }
                3 -> {
                    return ToolSuggestionFragment()
                }
                else -> {
                    return ToolColourWheelFragment()
                }
            }
        }
    }

}