package com.ndricim.nutils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
            showErrorDialog(this, "This is a testing error message")
        }
    }
}