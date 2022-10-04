package au.edu.swin.sdmd.w09_filehandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //File I/O using io java library
        val listOfStrings = mutableListOf<LinesData>()
        //Call the data file from raw directory
        val file = resources.openRawResource(R.raw.data).bufferedReader()


        //For each line approach
        file.forEachLine {
            //Split data by , comma
            val data = it.split(",")
            //Add each string into the mutable list using index
            listOfStrings.add(LinesData(data[0], data[1].toInt()))
        }

        //Print the string objects of the list
        for (line in listOfStrings) {
            Log.i("DATA","${line.word} and score is ${line.number}")

        }

        val listView = findViewById<RecyclerView>(R.id.lineList)

        //Call adapter to the view and assign adapter class
        listView.adapter = Adapter(listOfStrings)
        //Call layout manager on view to recycle views of the list
        listView.layoutManager = LinearLayoutManager(this)
    }
}

//Data class to define object of strings
data class LinesData(val word :String, val number: Int)