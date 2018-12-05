package br.com.fiap.viniciusgomes.jokenpokemon.api

import br.com.fiap.viniciusgomes.jokenpokemon.model.Pontuacao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JokenpoAPI {

    @POST("/jokenpokemon/pontuacao")
    fun enviarPontos(@Body pontuacao: Pontuacao): Call<Void>

    @GET("/jokenpokemon/pontuacao")
    fun buscarPontuacao(): Call<List<Pontuacao>>

}