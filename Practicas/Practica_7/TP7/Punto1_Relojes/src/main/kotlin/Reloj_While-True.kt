import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    while (true) {
        val hora = LocalTime.now().format(formatter)
        println("Hora: $hora")
        Thread.sleep(1000)
    }
}