package com.example.test

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val authority = "com.yudiz.demo.navigation.content_provider.CustomProvider"
        val contentUri: Uri = Uri.parse("content://${authority}")
        binding.btnGetContent.setOnClickListener {
            val cursor = contentResolver.query(contentUri, null, null, null, null, null)
            cursor?.moveToFirst()
                val sb = StringBuilder("lol")
                while (cursor?.moveToNext() == true) {
                    sb.append(cursor.getString(cursor.getColumnIndex("ID")))
                    sb.append(cursor.getString(cursor.getColumnIndex("NAME")))
                }
                binding.cpTextView.text = sb.toString()

        }
    }
}