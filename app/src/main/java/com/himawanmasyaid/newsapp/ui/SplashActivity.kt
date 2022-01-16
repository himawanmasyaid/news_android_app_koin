package com.himawanmasyaid.newsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawanmasyaid.newsapp.R
import com.himawanmasyaid.newsapp.base.BaseActivity
import com.himawanmasyaid.newsapp.databinding.ActivityMainBinding
import com.himawanmasyaid.newsapp.databinding.ActivitySplashBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch {
            delay(2000) // 2 second
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }

    }
}