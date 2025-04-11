package com.example.aulaactivityfragment

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textFilme: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)

        buttonFechar = findViewById(R.id.button_fechar)
        textFilme = findViewById(R.id.textFilme)

        // Recuperando dados de outra activity
        val bundle = intent.extras
        if ( bundle != null){

            val filme = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {// verificando a versão do android, se >= 33
                bundle.getParcelable("filme", Filme::class.java)
            }else{
                bundle.getParcelable("filme")
            }

            textFilme.text = "${filme?.nome} - ${filme?.descricao} - ${filme?.avalicao} - ${filme?.diretor} - ${filme?.distribuidor}"
        }

        buttonFechar.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}