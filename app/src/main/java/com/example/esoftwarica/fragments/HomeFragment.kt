package com.example.esoftwarica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esoftwarica.R
import com.example.esoftwarica.StudentData
import com.example.esoftwarica.adapter.StudentAdapter
import com.example.esoftwarica.model.Students

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        if(StudentData.get().List().size==0){
            loadStudents();
        }
        recyclerView=view.findViewById(R.id.recyclerView)
        val adapter= StudentAdapter(StudentData.get().List(),context!!)
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter

        return view;



    }

    private fun loadStudents(){
        StudentData.get().List().add(
                Students(1,"Nabin Vikram Thapa Magar",20,"Male","Sanepa",
                        "https://scontent.fktm3-1.fna.fbcdn.net/v/t31.0-8/12977235_140711152994596_4348146837854011430_o.jpg?_nc_cat=100&ccb=2&_nc_sid=174925&_nc_ohc=3uAGO1dEF3gAX9ngz7W&_nc_ht=scontent.fktm3-1.fna&oh=7945ec79c189a4a6ca6a00242d4abab9&oe=6027E1E8")
        )

        StudentData.get().List().add(
                Students(2,"Sujan Gurung",22,"Male","SuryaDarshan",
                        "https://scontent.fktm8-1.fna.fbcdn.net/v/t1.0-9/89356851_251174115912865_7891050963769753600_o.jpg?_nc_cat=107&ccb=2&_nc_sid=8bfeb9&_nc_ohc=3dAKweCjDDgAX8acdBZ&_nc_oc=AQmIEbbb9gd8EIoH-Mv6Sn10iAsiC4ROYPTR-TTJ9l1G8bAjXOluSnFq25WpVkLhgy0&_nc_ht=scontent.fktm8-1.fna&oh=c0281157fb44a631ecd19663c7c250ba&oe=602629ED")
        )

        StudentData.get().List().add(
                Students(3,"Dip Sapkota",22,"Male","Dilibazar",
                        "https://scontent.fktm3-1.fna.fbcdn.net/v/t1.0-1/p320x320/125542512_1037175063464375_5108204506547963151_n.jpg?_nc_cat=103&ccb=2&_nc_sid=7206a8&_nc_ohc=dhzJftr6rSQAX_vFNSh&_nc_ht=scontent.fktm3-1.fna&tp=6&oh=fdc3d401f089434e5cdcb32e48269dc1&oe=60259C3E")
        )

    }


}