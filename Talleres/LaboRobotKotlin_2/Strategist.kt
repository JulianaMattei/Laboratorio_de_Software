package aspitia.mattei

import robocode.JuniorRobot
import robocode.util.Utils
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt

object Strategist: BattleStrategist {

    override fun getOptimalStrategy(robot: JuniorRobot, strategy: BattleStrategy?): BattleStrategy =
        when {
            strategy == null -> GridWalker()
            robot.others < 3 -> strategy as? AgressiveStrategy ?: AgressiveStrategy()
            robot.energy > 60 -> strategy as? GridWalker ?: GridWalker()
            else -> strategy as? SafeMode ?: SafeMode()
        }


    private class GridWalker : BattleStrategy {
        private var quadrant = -1
        private var hits = 0
        private var collisions = 0
        private var forward = true

        override fun run(robot: JuniorRobot) {
            // Si es la primera vez me fijo en que cuadrante estoy y me muevo al punto deseado en el mismo

            if (quadrant == -1) {
                quadrant = whereAmI(robot)
                goToQuadrant(robot)
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
            when (quadrant) {
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
            hits++
            if (forward) {
                robot.ahead(50)
            } else {
                robot.back(50)
            }
            forward = !forward
            if (hits == 5) {
                hits = 0
                collisions = 0
                quadrant = (quadrant + 1) % 4
                goToQuadrant(robot)
            }
        }

        override fun onHitWall(robot: JuniorRobot) {
            robot.doNothing()
        }

        override fun onHitRobot(robot: JuniorRobot) {
            // Incremento la cantidad de colisiones y si llego a 3 colisiones me muevo al siguiente cuadrante
            collisions++
            if (collisions == 3) {
                hits = 0
                collisions = 0
                quadrant = (quadrant + 1) % 4
                goToQuadrant(robot)
            }
        }
    }

    private class SafeMode : BattleStrategy {
        private var quadrant = -1
        private var inPosition = false

        override fun run(robot: JuniorRobot) {
            if (quadrant == -1) {
                quadrant = whereAmI(robot)
                goToWall(robot)
            }

            if (quadrant == 0 || quadrant == 1) {
                robot.turnGunLeft(90)
                robot.turnGunRight(180)
                robot.turnGunLeft(90)
            } else {
                robot.turnGunRight(90)
                robot.turnGunLeft(180)
                robot.turnGunRight(90)
            }
            robot.ahead(50)
        }

        fun whereAmI(robot: JuniorRobot): Int {
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

        fun goToWall(robot: JuniorRobot) {
            // se mueve hacia arriba o abajo dependiendo del cuadrante donde está

            if (quadrant == 0 || quadrant == 1) {
                robot.turnTo(0)
                robot.ahead(robot.fieldHeight - robot.robotX)
            } else {
                robot.turnTo(180)
                robot.ahead(robot.robotX - robot.fieldHeight)
            }

            // Si estoy en los cuadrantes de arriba, el robot mira hacia un lado con el arma hacia abajo
            // Si estoy en los cuadrantes de abajo, el robot mira hacia un lado con el arma hacia arriba
            if (quadrant == 0 || quadrant == 1) {
                robot.turnTo(90)
                robot.turnGunTo(180)
            } else {
                robot.turnTo(90)
                robot.turnGunTo(0)
            }

            inPosition = true
        }

        override fun onScannedRobot(robot: JuniorRobot) {
            if (inPosition) {
                robot.turnGunTo(robot.scannedAngle)
                if (robot.scannedDistance < 200) {
                    robot.fire(2.0)
                } else robot.fire(0.5)
                robot.ahead(50)
            }
        }

        override fun onHitByBullet(robot: JuniorRobot) {
            robot.ahead(50)
        }

        override fun onHitWall(robot: JuniorRobot) {
            if (robot.heading == 90) {
                robot.turnTo(270)
            } else robot.turnTo(90)

            robot.ahead(50)
        }

        override fun onHitRobot(robot: JuniorRobot) {
            robot.turnGunTo(robot.hitRobotBearing)
            robot.fire(3.0)
        }
    }

    private class AgressiveStrategy : BattleStrategy {
        override fun run(robot: JuniorRobot) {
            robot.turnGunRight(30)
        }

        override fun onScannedRobot(robot: JuniorRobot) {
            val angle: Int = robot.scannedAngle
            val distance: Int = robot.scannedDistance
            val bearing: Int = robot.scannedBearing

            robot.turnTo(angle)
            robot.ahead(distance - 5)
            robot.bearGunTo(bearing)
            robot.fire(3.0)
        }

        override fun onHitByBullet(robot: JuniorRobot) {
            robot.doNothing()
        }

        override fun onHitWall(robot: JuniorRobot) {
            robot.doNothing()
        }

        override fun onHitRobot(robot: JuniorRobot) {
            robot.doNothing()
        }
    }
}
