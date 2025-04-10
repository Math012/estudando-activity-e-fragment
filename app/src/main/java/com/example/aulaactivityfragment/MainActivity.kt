package com.example.aulaactivityfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonAbrir = findViewById(R.id.button_abrir)
        buttonAbrir.setOnClickListener {

            val intent = Intent(this, DetalhesActivity::class.java)
            // Passando parametros para uma nova activity
            val filme = Filme(
                "Sem limites",
                "descrição do sem limites",
                4.8,
                "Matheus",
                "Netflix"
            )

            intent.putExtra("filme", filme)

            // Iniciando uma nova activity
            startActivity( intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}