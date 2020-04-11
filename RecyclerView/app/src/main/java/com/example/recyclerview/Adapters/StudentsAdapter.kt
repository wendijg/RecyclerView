package com.example.recyclerview.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.Data.StudentsEntity
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_student.view.*

class StudentsAdapter(val studentsList:ArrayList<StudentsEntity>, val context: Context): RecyclerView.Adapter<StudentsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentsHolder(inflater.inflate(R.layout.item_student, parent, false))
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.txvName.text = "${studentsList[position].name} ${studentsList[position].lastName}"
        holder.txvGender.text = if(studentsList[position].gender == 1) "Maculino" else "Femenino"
        holder.txvDateBirth.text = studentsList[position].birthday

        holder.ibtSetings.setOnClickListener{
            Toast.makeText(context, "Boton Configuracion ${studentsList[position].name}", Toast.LENGTH_LONG).show()
        }

        holder.ibtDelete.setOnClickListener{
            Toast.makeText(context, "Boton Eliminar ${studentsList[position].name}", Toast.LENGTH_LONG).show()
        }

    }

}

class StudentsHolder(view: View): RecyclerView.ViewHolder(view){
    val imvLogoItem = view.imvLogoItem
    val txvName = view.txvName
    val txvGender = view.txvGender
    val txvDateBirth = view.txvDateBirth
    val ibtDelete = view.ibtDelete
    val ibtSetings = view.ibtSetings
}