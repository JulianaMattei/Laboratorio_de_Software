package aspitia.mattei.kotlin

import robocode.JuniorRobot
import robocode.util.Utils
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt


class GridWalker : BattleStrategy {
    private var quadrant = -1
    private var hits = 0
    private var collisions = 0
    private var forward = true

    override fun run(robot: JuniorRobot) {
        // Si es la primera vez me fijo en que cuadrante estoy y me muevo al punto deseado en el mismo

        if (quadrant == -1) {
            this.quadrant = this.whereAmI(robot)
            this.goToQuadrant(robot)
        }

        // Si estoy en el cuadrante de arriba a la izquierda o en el de abajo a la derecha
        // comienzo a escanear hacia la izquierda. Sino, hacia la derecha.
        if (quadrant == 0 || quadrant == 2) {
            robot.turnGunLeft(135)
            robot.turnGunRight(180)
            robot.turnGunLeft(45)
        } else {
            robot.turnGunRight(135)
            robot.turnGunLeft(180)
            robot.turnGunRight(45)
        }

    }

    private fun whereAmI(robot: JuniorRobot): Int {
        /* Retora el cuadrante en el que se encuentra el robot actualmente
         * 0: arriba a la izquierda
         * 1: arriba a la derecha
         * 2: abajo a la derecha
         * 3: abajo a la izquierda
         */

        if (robot.robotX < (robot.fieldWidth / 2)) {
            return if (robot.robotY < (robot.fieldHeight / 2)) {
                3
            } else {
                0
            }
        } else if (robot.robotX > (robot.fieldWidth / 2)) {
            return if (robot.robotY > (robot.fieldHeight / 2)) {
                1
            } else {
                2
            }
        }
        return 0
    }

    private fun goToQuadrant(robot: JuniorRobot) {
        val distance: Double
        var angleDeg: Double
        val targetX: Int
        val targetY: Int
        // Cualculo el punto deseado (targetX, targetY) al que quiero moverme
        // segun el cuadrante al que me busco mover
        when (this.quadrant) {
            0 -> {
                targetX = robot.fieldWidth / 6
                targetY = robot.fieldHeight / 6 * 5
            }
            1 -> {
                targetX = robot.fieldWidth / 6 * 5
                targetY = robot.fieldHeight / 6 * 5
            }
            2 -> {
                targetX = robot.fieldWidth / 6 * 5
                targetY = robot.fieldHeight / 6
            }
            else -> {
                targetX = robot.fieldWidth / 6
                targetY = robot.fieldHeight / 6
            }
        }
        // Calculo la distancia al punto deseado
        distance = sqrt((targetX.toDouble() - robot.robotX).pow(2.0) + (targetY.toDouble() - robot.robotY).pow(2.0))

        // Calculo el angulo hacia el que me tengo que girar para ir hacia el punto
        angleDeg = Math.toDegrees(atan2(targetX.toDouble() - robot.robotX, targetY.toDouble() - robot.robotY))
        if (angleDeg < 0.0) {
            angleDeg += 360.0
        }

        // Giro y me muevo hacia el punto
        robot.turnRight(Utils.normalRelativeAngleDegrees(angleDeg - robot.heading).toInt())
        robot.ahead(distance.toInt())

        // Si estoy en los cuadrantes de abajo, el robot empieza mirando hacia arriba
        // Si estoy en los cuadrantes de arriba, el robot empieza mirando hacia abajo
        if (quadrant == 2 || quadrant == 3) {
            robot.turnTo(0)
            robot.turnGunTo(0)
        } else {
            robot.turnTo(180)
            robot.turnGunTo(180)
        }
    }

    override fun onScannedRobot(robot: JuniorRobot) {
        // Giro el arma hacia el robot y disparo
        robot.bearGunTo(robot.scannedBearing)
        robot.fire(2.0)
    }

    override fun onHitByBullet(robot: JuniorRobot) {
        // Incremento hits y me muevo. Cambio la direccion y si llego a 5 hits me muevo al siguiente cuadrante
        this.hits++
        if (forward) {
            robot.ahead(50)
        } else {
            robot.back(50)
        }
        forward = !forward
        if (this.hits == 5) {
            this.hits = 0
            this.collisions = 0
            this.quadrant = (this.quadrant + 1) % 4
            this.goToQuadrant(robot)
        }
    }

    override fun onHitWall(robot: JuniorRobot) {
    }

    override fun onHitRobot(robot: JuniorRobot) {
        // Incremento la cantidad de colisiones y si llego a 3 colisiones me muevo al siguiente cuadrante
        collisions++
        if (this.collisions == 3) {
            this.hits = 0
            this.collisions = 0
            this.quadrant = (this.quadrant + 1) % 4
            this.goToQuadrant(robot)
        }
    }
}
