package au.edu.swin.sdmd.w09_filehandling

import java.io.File

fun main() {

    //File I/O using io java library
    val listOfStrings = mutableListOf<Lines>()
    val file = File("C:\\Users\\andyc\\Documents\\code\\Software Mobile Dev\\W09FileHandling\\app\\src\\main\\java\\au\\edu\\swin\\sdmd\\w09_filehandling\\data.txt")

    /*file.forEachLine {
        println(it)
    }*/

    //Read line to read a list of strings
    /*for (line in file.readLines()) {
        println(line)
    }*/

    //For each line approach
    file.forEachLine {
        //Split data by , comma
        val data = it.split(",")
        //Add each string into the mutable list using index
        listOfStrings.add(Lines(data[0], data[1].toInt()))
    }

    //Print the string objects of the list
    for (line in listOfStrings) {
        println("${line.word} and score is ${line.number}")

    }

}

//Data class to define object of strings
data class Lines(val word :String, val number: Int)