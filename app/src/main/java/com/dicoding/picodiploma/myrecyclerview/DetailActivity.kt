package com.dicoding.picodiploma.myrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.myrecyclerview.databinding.ActivityDetailBinding
import com.dicoding.picodiploma.myrecyclerview.model.Hero

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra<Hero>(HERO_DETAIL) as Hero

        title = hero.name
        Glide.with(this)
            .load(hero.photo) // URL Gambar
            .circleCrop() // Mengubah image menjadi lingkaran
            .into(binding.imageView) // imageView mana yang akan diterapkan
        binding.textView.text = hero.name
        binding.textView2.text = hero.description
    }

    companion object {
        const val HERO_DETAIL = "hero_detail"
    }
}