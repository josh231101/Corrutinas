package com.example.corrutinas.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutinas.models.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Importante         ": ViewModel()"
class StudentViewModel: ViewModel() {
    var selectedStudent by mutableStateOf("")

    fun getData() {
        //Init coroutine
        viewModelScope.launch {
            //Logica del hilo
            selectedStudent = "Buscando estudiante afortunado"
            getRandomStudent()
        }
    }

    //Las funciones a utilizar dentro del launch deben tener el prefijo Suspend
    suspend fun getRandomStudent() {
        val studentName: String = withContext(Dispatchers.IO) {
            delay(5000)

            //Bloque de código que estará en subproceso para no congelar la interfaz del usuario
            var list = mutableListOf<Student>()

            list.add(Student(1, "Josué David", true))
            list.add(Student(2, "Alfonso Estudiante", true))
            list.add(Student(3, "David Alejandro", true))
            list.add(Student(4, "Sebastián", true))
            list.add(Student(5, "Gerardo", true))
            list.add(Student(6, "Raymundo Dolphins :(", false))
            list.add(Student(7, "María Fernanda", true))
            list.add(Student(8, "Javier", true))
            list.add(Student(9, "Edson", true))
            list.add(Student(10, "Aylin", true))
            list.add(Student(11, "Yos", true))

            list.random().name
        }
        selectedStudent = studentName
    }
}