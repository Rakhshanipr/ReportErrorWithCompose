package com.example.reporterrorwithcompose

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val languageToLoad = "fa" // your language

        val locale = Locale(languageToLoad)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.getResources().updateConfiguration(
            config,
            baseContext.getResources().getDisplayMetrics()
        )
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container,ReportErrorFragment.newInstance())
            .commit()
    }

}