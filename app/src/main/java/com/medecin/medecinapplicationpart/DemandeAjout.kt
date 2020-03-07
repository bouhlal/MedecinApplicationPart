package com.medecin.medecinapplicationpart


import androidx.room.Entity
import androidx.room.PrimaryKey

import androidx.room.ForeignKey





@Entity(tableName = "demandeajout", foreignKeys = arrayOf(ForeignKey(entity =
Medecin::class, parentColumns = arrayOf("medecin"),
        childColumns = arrayOf("medecin"),
        onDelete = ForeignKey.CASCADE),ForeignKey(entity =
Patient::class, parentColumns = arrayOf("patient"),
        childColumns = arrayOf("patient"),
        onDelete = ForeignKey.CASCADE)))
        data class DemandeAjout (
        @PrimaryKey
        var id:Int,
        val date: String,
        val statut : String,
        val nom_patient : String,
        val patient: Int,
        val medecin: Int
        )