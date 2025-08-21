package com.views.recyclables.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.views.recyclables.NamesRvAdapter
import com.views.recyclables.R

class MainActivity : AppCompatActivity() {
    lateinit var rvNames: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onResume(){
        super.onResume()
        rvNames = findViewById(R.id.rvNames)

        val names = listOf("Anne", "Andrew", "Ruby", "James", "Rabbecca", "Sara", "Mercy" ,"Thomas,", "Linn,", "Berissa", "Ada", "Rabbecca", "Sara", "Mercy" ,"Thomas,", "Linn,", "Berissa", "Ada")
        val namesAdapter = NamesRvAdapter(names)

        rvNames.layoutManager = LinearLayoutManager(this)
        rvNames.adapter = namesAdapter
    }
}
