import kotlinx.coroutines.*
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main(): kotlin.Unit = runBlocking {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    launch {
        while (isActive) {
            val hora = LocalTime.now().format(formatter)
            println("Hora: $hora")
            delay(1000)
        }
    }

    delay(1000)
    println("Finalizando")
}