package br.com.fiap.viniciusgomes.jokenpokemon.model

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.com.fiap.viniciusgomes.jokenpokemon.R
import br.com.fiap.viniciusgomes.jokenpokemon.adapter.PontuacaoAdapter
import br.com.fiap.viniciusgomes.jokenpokemon.api.JokenpoAPI
import kotlinx.android.synthetic.main.activity_ranking.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RankingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)
        carregaPontuacoes()
    }

    private fun carregaPontuacoes() {
        var resultado: List<Pontuacao> = emptyList()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://gamestjd.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(JokenpoAPI::class.java!!)
        service.buscarPontuacao()
                .enqueue(object : Callback<List<Pontuacao>> {
                    override fun onFailure(call: Call<List<Pontuacao>>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<List<Pontuacao>>?, response: Response<List<Pontuacao>>?) {
                        setList(response?.body())
                    }
                })
    }

    private fun setList(pontuacoes: List<Pontuacao>?) {
        rvRanking.adapter = PontuacaoAdapter(pontuacoes!!, this, {
            Log.i("TAG", "MEU ITEM")
        })
        val layoutManager = LinearLayoutManager(this)
        rvRanking.layoutManager = layoutManager
    }
}
