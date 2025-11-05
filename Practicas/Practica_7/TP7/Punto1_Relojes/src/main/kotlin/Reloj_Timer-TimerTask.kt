import java.time.format.DateTimeFormatter
import java.time.LocalTime
import java.util.Timer
import java.util.TimerTask

fun main() {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    val timer = Timer()

    timer.scheduleAtFixedRate(object : TimerTask() {
        override fun run() {
            val hora = LocalTime.now().format(formatter)
            println("Hora: $hora")
        }
    }, 0, 1000)
}