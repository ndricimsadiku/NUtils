package com.ndricim.nutils

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ndricim.alert_dialog_util.NUtilsActivity
import com.ndricim.alert_dialog_util.showErrorDialog
import com.ndricim.nutils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding.button.setOnClickListener {
            showErrorDialog(this, "This is my first error text using an library")

            Handler().postDelayed({
                startActivity(Intent(applicationContext, NUtilsActivity::class.java))
            }, 3000)
        }
    }
}