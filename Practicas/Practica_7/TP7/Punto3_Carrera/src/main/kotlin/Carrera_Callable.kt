import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class CorredorCallable (private val nombre : String) : Callable<String> {

    override fun call(): String {
        var metros = 0
        while (metros < 100) {
            val avance = (1..100).random()
            metros += avance
            if (metros > 100) metros = 100

            println("${Thread.currentThread().name} - $nombre recorrió $metros metros")

            if ((1..100).random() <= 5) {
                throw Exception("$nombre abandonó la carrera")
            }

            Thread.sleep((200..600).random().toLong())
        }

        return "$nombre llegó a la meta"
    }
}

fun main() {
    val pool = Executors.newFixedThreadPool(5)
    val corredores = listOf(
        CorredorCallable("Corredor 1"),
        CorredorCallable("Corredor 2"),
        CorredorCallable("Corredor 3"),
        CorredorCallable("Corredor 4"),
        CorredorCallable("Corredor 5")
    )

    val resultados = corredores.map {pool.submit(it)  }

    resultados.forEachIndexed { i, future ->
        try {
            val resultado = future.get()
            println(resultado)
        } catch (e: Exception) {
            println("${e.cause?.message}")
        }
    }

    pool.shutdown()
}