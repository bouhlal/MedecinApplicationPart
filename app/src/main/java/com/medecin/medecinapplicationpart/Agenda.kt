package com.medecin.medecinapplicationpart

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "agenda")
data class Agenda(
    @PrimaryKey
    var id_agenda:Int,
    var patient : Int,
    val medecin : Int
)

