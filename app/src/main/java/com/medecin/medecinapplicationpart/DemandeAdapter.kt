package com.medecin.medecinapplicationpart

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.recyclerview.widget.RecyclerView

import java.util.*
import kotlin.collections.ArrayList
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent

import com.medecin.medecinapplicationpart.MainActivity
import android.net.Uri
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MedecinAdapter(private val myDataset: ArrayList<DemandeAjout>) :
    RecyclerView.Adapter<MedecinAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val date = view?.findViewById(R.id.date) as TextView
        val phone = view?.findViewById(R.id.phone) as TextView
        val nom_patient = view?.findViewById(R.id.nom_patient) as TextView
        val accept_btn = view?.findViewById(R.id.accept_button) as ImageButton

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MedecinAdapter.MyViewHolder {
        // create a new view
        val listElement = LayoutInflater.from(parent.context)
            .inflate(com.medecin.medecinapplicationpart.R.layout.list_element, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(listElement)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.date.text = myDataset[position].date
        holder.phone.text = myDataset[position].patient.toString()
        holder.nom_patient.text = myDataset[position].nom_patient
        holder.accept_btn.setOnClickListener {
            val call = RetrofitService.endpoint.acceptPatient(myDataset[position].patient.toString(),myDataset[position].medecin.toString())
            call.enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response:
                Response<String>?) {
                    myDataset.removeAt(position)
                    notifyItemRemoved(position)
                    notifyDataSetChanged()
                } override fun onFailure(call: Call<String>, t: Throwable) {
                }
            })
    }}

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}

