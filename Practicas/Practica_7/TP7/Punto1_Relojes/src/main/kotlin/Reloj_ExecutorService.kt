import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val scheduler = Executors.newSingleThreadScheduledExecutor()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    val task = Runnable {
        val hora = LocalTime.now().format(formatter)
        println("hora: $hora")
    }

    scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS)
}