package com.nowxel.ukrpravda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.nowxel.ukrpravda.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private var isMenuOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.fragmentHolder, MainFragment()).commit()

        binding.menuButton.setOnClickListener {
            isMenuOpened = !isMenuOpened
            updateMenuViews()
        }

        binding.clubButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://club.pravda.com.ua/")))
        }
    }

    private fun updateMenuViews() {
        if (isMenuOpened) {
            binding.menuButton.setImageResource(R.drawable.ic_close)
            binding.toolbar.setBackgroundColor(getColor(R.color.dark_grey))
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentHolder, MenuFragment())
                .addToBackStack(null)
                .commit()
        } else {
            binding.menuButton.setImageResource(R.drawable.ic_menu)
            binding.toolbar.setBackgroundColor(getColor(R.color.cherry))
            supportFragmentManager.popBackStack()
        }
    }
}