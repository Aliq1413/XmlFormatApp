package com.example.xmlformatapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import kotlin.collections.ArrayList
class MainActivity : AppCompatActivity() {
    lateinit var studentsRv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        studentsRv = findViewById(R.id.students_rv)
        studentsRv.adapter = RVAdapter(getStudents())
        studentsRv.layoutManager = GridLayoutManager(this, 2)
    }
    private fun getStudents(): ArrayList<Student>{
        var studentsList = arrayListOf<Student>()
        try {
            val parser = XMLParser()
            val inputStream = assets.open("student_details.xml")
            studentsList = parser.parse(inputStream)
        } catch (e: Exception){ e.printStackTrace() }
        return studentsList
    }
}