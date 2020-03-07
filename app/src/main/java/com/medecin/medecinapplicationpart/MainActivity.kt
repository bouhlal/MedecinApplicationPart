package com.medecin.medecinapplicationpart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_element.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private  var myDataset : ArrayList<DemandeAjout> = ArrayList()


    fun updateView(){
        viewAdapter.notifyDataSetChanged()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewAdapter = MedecinAdapter(myDataset)
        viewManager = LinearLayoutManager(this)

        val call = RetrofitService.endpoint.getDemandeAjout("444444")
        call.enqueue(object: Callback<List<DemandeAjout>> {
            override fun onResponse(call: Call<List<DemandeAjout>>?, response:
            Response<List<DemandeAjout>>?) {
                Log.e("je suis", "heeeere")
                Log.e("Resultat est",response?.body()!!.toString())
                myDataset.addAll(ArrayList( response?.body()!!))
                Log.e("dataset",myDataset.toString())
                viewAdapter.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<DemandeAjout>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t!!.message, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView = findViewById<RecyclerView>(R.id.list_demande_ajout).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
}
