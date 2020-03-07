package com.medecin.medecinapplicationpart

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "patient")
data class Patient(
    @PrimaryKey
    var phone:Int,
    var NSS : Int,
    val prenom : String,
    val Nom : String,
    val adresse : String,
    val password : String,
    val newpassword : String
)
