package com.medecin.medecinapplicationpart

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoint {
    // Call<List<Player>: une fonction callback qui retourne une liste
    @GET("getMedecin")
    fun getmedecin(): Call<List<Medecin>>
    @GET("getMedecinCommune/{commune}")
    fun getmedecinCommune(@Path ("commune") isbn:String): Call<List<Medecin>>
    @GET("getMedecinSpecialite/{specialite}")
    fun getmedecinSpecialite(@Path ("specialite") isbn:String): Call<List<Medecin>>
    @GET("getMedecin/{commune}/{specialite}")
    fun getMedecinSpecAndComm(@Path ("commune") isbn:String,@Path ("specialite") isbn2:String): Call<List<Medecin>>
    @GET("getMedTraitant/{phone}/{statut}")
    fun getMedTraitant(@Path ("phone") isbn:String,@Path ("statut") isbn2:String): Call<List<Medecin>>
    @GET("getDemandeAjout/{medecin}")
    fun getDemandeAjout(@Path ("medecin") isbn:String): Call<List<DemandeAjout>>

    @POST("/medecin/acceptpatient/{patient}/{medecin}")
    fun acceptPatient(@Path ("patient") patient:String,@Path ("medecin") medecin:String): Call<String>
}