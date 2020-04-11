package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Adapters.StudentsAdapter
import com.example.recyclerview.Data.StudentsDb
import com.example.recyclerview.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)
    private lateinit var studentsList : ArrayList<StudentsEntity>
    private lateinit var studentsAdapter : StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //studentsDb.studentAdd(StudentsEntity(-1, "Rebeca", "Ricaño", 2, "1999/12/13"))
        //studentsDb.studentAdd(StudentsEntity(-1, "Daniel", "De La O", 1, "1999/03/18"))
        //studentsDb.studentAdd(StudentsEntity(-1, "Ashley", "De Luna", 2, "1998/08/09"))


        studentsList = studentsDb.stundetsGetAll2()
        studentsAdapter = StudentsAdapter(studentsList, this@MainActivity)

        val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        rvwStudents.layoutManager = linearLayoutManager
        rvwStudents.setHasFixedSize(true)
        rvwStudents.adapter = studentsAdapter


    }
}
