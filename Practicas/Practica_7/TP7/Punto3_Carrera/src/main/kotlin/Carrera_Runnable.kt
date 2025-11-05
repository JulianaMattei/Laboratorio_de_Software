import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

class Corredor (private val nombre : String, private val carreraActiva : AtomicBoolean) : Runnable {

    override fun run() {
        var metros = 0
        while (metros < 100 && carreraActiva.get()) {
            val avance = (1..10).random()
            metros += avance
            if (metros > 100) metros = 100
            println("${Thread.currentThread().name} - $nombre ha recorrido $metros metros")
            Thread.sleep((200..600).random().toLong())
        }

        if (metros >= 100 && carreraActiva.compareAndSet(true, false)) {
            println("$nombre ganó la carrera")
        } else if (!carreraActiva.get()) {
            println("$nombre se detiene, la carrera ya terminó")
        }
    }
}

fun main() {
    val pool = Executors.newFixedThreadPool(5)
    val carreraActiva = AtomicBoolean(true)

    val corredores = listOf(
        Corredor("Corredor 1", carreraActiva),
        Corredor("Corredor 2", carreraActiva),
        Corredor("Corredor 3", carreraActiva),
        Corredor("Corredor 4", carreraActiva),
        Corredor("Corredor 5", carreraActiva)
    )

    println("Comienza la carrera")

    corredores.forEach { pool.execute(it) }

    pool.shutdown()

    pool.awaitTermination(1, TimeUnit.MINUTES)

}