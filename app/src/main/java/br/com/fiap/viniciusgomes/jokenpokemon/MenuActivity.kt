package br.com.fiap.viniciusgomes.jokenpokemon

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.viniciusgomes.jokenpokemon.model.RankingActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btRanking.setOnClickListener {
            startActivityForResult(Intent(this, RankingActivity::class.java),0)
        }

        btSobre.setOnClickListener {
            startActivityForResult(Intent(this, SobreActivity::class.java),0)
        }
    }
}
