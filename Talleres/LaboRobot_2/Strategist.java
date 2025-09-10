package aspitia.mattei;

import robocode.JuniorRobot;
import robocode.util.Utils;

public class Strategist implements BattleStrategist {
    private static Strategist strategistInstance;

    private Strategist() {
    }

    public static Strategist getStrategist(){
        if (strategistInstance == null) {
            strategistInstance = new Strategist();
        }
        return strategistInstance;
    }


    @Override
    public BattleStrategy getOptimalStrategy(JuniorRobot robot, BattleStrategy strategy) {
        if (strategy == null) {
            return new GridWalker();
        }
        if (robot.others < 3) {
            if (strategy.getClass() == AgressiveStrategy.class) {
                return strategy;
            } else {
                return new AgressiveStrategy();
            }
        }
        if (robot.energy > 60) {
            if (strategy.getClass() == GridWalker.class) {
                return strategy;
            } else {
                return new GridWalker();
            }
        }
        if (strategy.getClass() == SafeMode.class) {
            return strategy;
        } else {
            return new SafeMode();
        }
    }

    private class GridWalker implements BattleStrategy {

        private int quadrant = -1;
        private int hits = 0;
        private int collisions = 0;
        private boolean forward = true;


        @Override
        public void run(JuniorRobot robot) {
            // Si es la primera vez me fijo en que cuadrante estoy y me muevo al punto deseado en el mismo
            if (quadrant == -1) {
                this.quadrant = this.whereAmI(robot);
                this.goToQuadrant(robot);
            }

            // Si estoy en el cuadrante de arriba a la izquierda o en el de abajo a la derecha
            // comienzo a escanear hacia la izquierda. Sino, hacia la derecha.
            if (quadrant == 0 || quadrant == 2) {
                robot.turnGunLeft(135);
                robot.turnGunRight(180);
                robot.turnGunLeft(45);
            } else {
                robot.turnGunRight(135);
                robot.turnGunLeft(180);
                robot.turnGunRight(45);
            }
        }

        private int whereAmI(JuniorRobot robot) {
            /* Retora el cuadrante en el que se encuentra el robot actualmente
             * 0: arriba a la izquierda
             * 1: arriba a la derecha
             * 2: abajo a la derecha
             * 3: abajo a la izquierda
             */

            if (robot.robotX < (robot.fieldWidth / 2)) {
                if (robot.robotY < (robot.fieldHeight / 2)) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (robot.robotX > (robot.fieldWidth / 2)) {
                if (robot.robotY > (robot.fieldHeight / 2)) {
                    return 1;
                } else {
                    return 2;
                }
            }
            return 0;
        }

        private void goToQuadrant(JuniorRobot robot)  {
            double distance, angleDeg;
            int targetX, targetY;
            // Cualculo el punto deseado (targetX, targetY) al que quiero moverme
            // segun el cuadrante al que me busco mover
            if (this.quadrant == 0) {
                targetX = robot.fieldWidth/6;
                targetY = robot.fieldHeight/6*5;
            } else if  (this.quadrant == 1) {
                targetX = robot.fieldWidth/6*5;
                targetY = robot.fieldHeight/6*5;
            } else if  (this.quadrant == 2) {
                targetX = robot.fieldWidth/6*5;
                targetY = robot.fieldHeight/6;
            } else {
                targetX = robot.fieldWidth/6;
                targetY = robot.fieldHeight/6;
            }
            // Calculo la distancia al punto deseado
            distance = Math.sqrt(Math.pow((double)targetX - robot.robotX, 2) + Math.pow((double)targetY - robot.robotY, 2));

            // Calculo el angulo hacia el que me tengo que girar para ir hacia el punto
            angleDeg = Math.toDegrees(Math.atan2((double)targetX - robot.robotX, (double)targetY - robot.robotY));
            if(angleDeg < 0){
                angleDeg += 360;
            }

            // Giro y me muevo hacia el punto
            robot.turnRight((int) Utils.normalRelativeAngleDegrees(angleDeg - robot.heading));
            robot.ahead((int)distance);

            // Si estoy en los cuadrantes de abajo, el robot empieza mirando hacia arriba
            // Si estoy en los cuadrantes de arriba, el robot empieza mirando hacia abajo
            if (quadrant == 2 || quadrant == 3) {
                robot.turnTo(0);
                robot.turnGunTo(0);
            } else {
                robot.turnTo(180);
                robot.turnGunTo(180);
            }

        }

        @Override
        public void onScannedRobot(JuniorRobot robot) {
            // Giro el arma hacia el robot y disparo
            robot.bearGunTo(robot.scannedBearing);
            robot.fire((double)2.0F);
        }

        @Override
        public void onHitByBullet(JuniorRobot robot) {
            // Incremento hits y me muevo. Cambio la direccion y si llego a 5 hits me muevo al siguiente cuadrante
            this.hits++;
            if (forward) {
                robot.ahead(50);
            } else {
                robot.back(50);
            }
            forward = !forward;
            if (this.hits == 5) {
                this.hits = 0;
                this.collisions = 0;
                this.quadrant = (this.quadrant + 1) % 4;
                this.goToQuadrant(robot);
            }
        }

        @Override
        public void onHitWall(JuniorRobot robot) {

        }

        @Override
        public void onHitRobot(JuniorRobot robot) {
            // Incremento la cantidad de colisiones y si llego a 3 colisiones me muevo al siguiente cuadrante
            collisions++;
            if (this.collisions == 3) {
                this.hits = 0;
                this.collisions = 0;
                this.quadrant = (this.quadrant + 1) % 4;
                this.goToQuadrant(robot);
            }
        }
    }

    private class SafeMode implements BattleStrategy {

        private int quadrant = -1;
        private boolean inPosition = false;

        @Override
        public void run(JuniorRobot robot) {
            if (quadrant == -1) {
                this.quadrant = this.whereAmI(robot);
                this.goToWall(robot);
            }

            if (quadrant == 0 || quadrant == 1) {
                robot.turnGunLeft(90);
                robot.turnGunRight(180);
                robot.turnGunLeft(90);
            } else {
                robot.turnGunRight(90);
                robot.turnGunLeft(180);
                robot.turnGunRight(90);
            }
            robot.ahead(50);

        }

        private int whereAmI(JuniorRobot robot) {
            /* Retora el cuadrante en el que se encuentra el robot actualmente
             * 0: arriba a la izquierda
             * 1: arriba a la derecha
             * 2: abajo a la derecha
             * 3: abajo a la izquierda
             */

            if (robot.robotX < (robot.fieldWidth / 2)) {
                if (robot.robotY < (robot.fieldHeight / 2)) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (robot.robotX > (robot.fieldWidth / 2)) {
                if (robot.robotY > (robot.fieldHeight / 2)) {
                    return 1;
                } else {
                    return 2;
                }
            }
            return 0;
        }

        private void goToWall(JuniorRobot robot)  {

            // se mueve hacia arriba o abajo dependiendo del cuadrante donde está
            if (this.quadrant == 0 || this.quadrant == 1) {
                robot.turnTo(0);
                robot.ahead(robot.fieldHeight - robot.robotX);
            } else {
                robot.turnTo(180);
                robot.ahead(robot.robotX - robot.fieldHeight);
            }

            // Si estoy en los cuadrantes de arriba, el robot mira hacia un lado con el arma hacia abajo
            // Si estoy en los cuadrantes de abajo, el robot mira hacia un lado con el arma hacia arriba
            if (quadrant == 0 || quadrant == 1) {
                robot.turnTo(90);
                robot.turnGunTo(180);
            } else {
                robot.turnTo(90);
                robot.turnGunTo(0);
            }

            inPosition = true;

        }

        @Override
        public void onScannedRobot(JuniorRobot robot) {
            if (inPosition) {
                robot.turnGunTo(robot.scannedAngle);
                if (robot.scannedDistance < 200) {
                    robot.fire((double)2.0F);
                } else robot.fire((double)0.5F);
                robot.ahead(50);
            }
        }

        @Override
        public void onHitByBullet(JuniorRobot robot) {
            robot.ahead(50);
        }

        @Override
        public void onHitWall(JuniorRobot robot) {
            if (robot.heading == 90) {
                robot.turnTo(270);
            } else robot.turnTo(90);

            robot.ahead(50);
        }

        @Override
        public void onHitRobot(JuniorRobot robot) {
            robot.turnGunTo(robot.hitRobotBearing);
            robot.fire((double)3.0F);
        }
    }

    private class AgressiveStrategy implements BattleStrategy {

        @Override
        public void run(JuniorRobot robot) {
            robot.turnGunRight(30);
        }

        @Override
        public void onScannedRobot(JuniorRobot robot) {
            int angle = robot.scannedAngle;
            int distance = robot.scannedDistance;
            int bearing = robot.scannedBearing;

            robot.turnTo(angle);
            robot.ahead(distance - 5);
            robot.bearGunTo(bearing);
            robot.fire((double)3.0F);
        }

        @Override
        public void onHitByBullet(JuniorRobot robot) {
            robot.doNothing();
        }

        @Override
        public void onHitWall(JuniorRobot robot) {
            robot.doNothing();
        }

        @Override
        public void onHitRobot(JuniorRobot robot) {
            robot.doNothing();
        }
    }
}
