package com.coffeeandcookies.cursokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Test : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var unNumero = 1
        var otroNumero : Int = 11
        Log.d("app","esto es un numero "+unNumero)
        Log.d("app","esto es otro numero "+otroNumero)
       // var unNumero = 2
        var mander : Char = 's'
        var anio : Int = 2020
        var anioNac : Int = 1988
        var edad : Int

        edad = anio - anioNac
        var cumplio : Boolean

        cumplio = false

        Log.d("app","mi edad es "+edad)

        var Resultado = ejemploConRetorno("Gonzalo1","Benoffi")

        if (Resultado == "Mi nombre es Gonzalo Benoffi")
        {
            Log.d("app","soy yo")
        }
        else
        {
            Log.d("app","No soy Gonzalo")
        }

        Log.d("app",Resultado)

        var Mensaje = mayorEdad(edad)

        Log.d("app",Mensaje)

        getMonth(1)

        probandoArrays()

        probandoMutable()

    }
}

//si le ponemos el ? al final significa que puede ver en null
fun funcionNuevaEjemplo(numero1 : Int, numero2: Int)
{
    var numero3 : Int
    numero3 = numero1 - numero2;
}


fun ejemploConRetorno(nombre : String, apellido: String) : String
{
    return "Mi nombre es $nombre $apellido"
}

fun mayorEdad(edad : Int) : String
{
    var rta = ""
    if (edad > 18)
    {
        rta = "Sos mayor de edad"
    }
    else
    {
        rta = "Al lobby, a seguir participando"
    }
    return rta

}


fun getMonth(month : Int){
    when (month) {
        1 -> Log.e("mes","Enero")
        2 -> Log.w("mes","Febrero")
        3 -> Log.d("mes","Marzo")
        4 -> Log.i("mes","Abril")
        5 -> Log.d("mes","Mayo")
        6 -> Log.d("mes","Junio")
        7 -> Log.d("mes","Julio")
        8 -> Log.d("mes","Agosto")
        9 -> Log.d("mes","Septiembre")
        10 -> Log.d("mes","Octubre")
        11 -> Log.d("mes","Noviembre")
        12 -> Log.d("mes","Diciembre")
        else -> {
            Log.d("mes","No corresponde a ningún mes del año")
        }
    }
}


fun getMonthRange(month : Int){
    when (month) {
        1,2,3 -> print("Primer trimestre del año")
        4,5,6 -> print("segundo trimestre del año")
        7,8,9 -> print("tercer trimestre del año")
        10,11,12 -> print("cuarto trimestre del año")
    }
}

fun getMonthIn(month : Int){
    when (month) {
        in 1..6 -> print("Primer semestre")
        in 7..12 -> print("segundo semestre")
        !in 1..12 -> print("no es un mes válido")
    }
}

fun result(value: Any){
    when (value){
        is Int -> print(value + 1)
        is String -> print("El texto es $value")
        is Boolean -> if (value) print("es verdadero") else print("es falso")
    }
}

fun result(month : Int){
    val response : String = when (month) {
        in 1..6 -> "Primer semestre"
        in 7..12 -> "segundo semestre"
        !in 1..12 -> "no es un mes válido"
        else ->  "error"
    }
}
fun arrays()
{
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    Log.d("arrays",(weekDays.get(0)))
    Log.d("arrays",(weekDays.get(1)))
    Log.d("arrays",(weekDays.get(2)))
    Log.d("arrays",(weekDays.get(3)))
    Log.d("arrays",(weekDays.get(4)))
    Log.d("arrays",(weekDays.get(5)))
    Log.d("arrays",(weekDays.get(6)))

    if(weekDays.size >= 8){
        Log.d("arrays",(weekDays.get(7)))
    }else
    {
        Log.d("arrays",("no tiene más parámetros la array"))
    }

    weekDays.set(0, "Horrible lunes") //Contenía Lunes
    weekDays.set(4, "Por fin viernes") //Contenía Viernes

    for (posicion in weekDays.indices)
    {
        Log.d("arrays",(weekDays.get(posicion)))
    }

    for ((posicion, valor) in weekDays.withIndex()) {
        Log.d("array","La posición $posicion contiene el valor $valor")
    }

    for (weekDay in weekDays) {
        Log.d("array", weekDay)
    }

}

fun probandoArrays()
{

    val readOnly: List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    readOnly.size //Muestra el tamaño de la lista
    readOnly.get(3) //Devuelve el valor de la posición 3
    readOnly.first() //Devuelve el primer valor
    readOnly.last() //Devuelve el último valor
    println(readOnly) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]


    readOnly.size //Muestra el tamaño de la lista
    readOnly.get(3) //Devuelve el valor de la posición 3
    readOnly.first() //Devuelve el primer valor
    readOnly.last() //Devuelve el último valor


    var lista =  ArrayList<String>() //inicializa

    var lista2: ArrayList<String> = ArrayList<String>()  //tipo especifico con los : y asignacion con el =

    //var lista3: ArrayList<String> = ArrayList<String> //invalida, faltan los ()

    lista.add("5")
    lista.add("4")
    lista.add("3")
    lista.add("2")
    lista.add("1")

    for (numero in lista)
    {
        Log.d("array","numero es $numero")
    }

    Log.d("array","cantidad -> "+lista.size)
}

fun probandoMutable() {
    var mutableList: MutableList<String> =
        mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")

    Log.d("mutable", mutableList.toString()) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado]

    mutableList.add("Domingo")

    Log.d("mutable", mutableList.toString()) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]

    mutableList.none() //Nos devuelve un true si está vacía la lista
    mutableList.firstOrNull() //Nos devolverá el primer campo, y si no hay, un null.
    mutableList.elementAtOrNull(2) //El elemento del índice 2, si no hay, devolverá un null
    mutableList.lastOrNull() //Último valor de la lista o null

}

