package com.kirei.dayoffapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kirei.dayoffapp.R
import com.kirei.dayoffapp.model.ResultsItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        ib_back_detail.setOnClickListener {
            startActivity(Intent(
                    MainActivity.getLaunchService(
                            this
                    )
            ))
        }
        val movie = intent.getParcelableExtra<ResultsItem>("EXTRA_MOVIE") as ResultsItem
        Glide.with(this).load(movie.posterPath).into(iv_poster_movie)
        Glide.with(this).load(movie.backdropPath).into(iv_back_path)
        tv_synopsis.text = movie.overview
        tv_title.text = movie.title
        tv_releasedate.text = movie.releaseDate
        tv_rating.text = movie.voteCount.toString()
    }
}