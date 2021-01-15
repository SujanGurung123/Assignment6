package com.example.esoftwarica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.esoftwarica.R
import com.example.esoftwarica.model.Students
import de.hdodenhof.circleimageview.CircleImageView


class StudentAdapter(
        val studentdata:ArrayList<Students>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    //creating Entity
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgDel: ImageView
        val imgProfile: ImageView
        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView


        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            imgDel=view.findViewById(R.id.imgDel)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentdata[position]
        holder.tvName.text=student.name
        holder.tvAge.text=student.age.toString()
        holder.tvAddress.text=student.Address
        holder.tvGender.text=student.gender

        //load image with Glide Library
        Glide.with(context)
                .load(student.image)
                .into(holder.imgProfile)

        holder.imgDel.setOnClickListener{
            studentdata.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            notifyItemRangeChanged(position,studentdata.size)
        }
    }

    override fun getItemCount(): Int {
        return studentdata.size
    }

}



