package aspitia.mattei.kotlin

import robocode.JuniorRobot

class WandererStrategy : BattleStrategy {
    private var hits = 0

    override fun run(robot: JuniorRobot) {
        while (true) {
            robot.turnAheadRight(30, 30)
            robot.ahead(20)
            robot.turnAheadLeft(30, 30)
            robot.turnGunRight(360)
        }
    }

    override fun onScannedRobot(robot: JuniorRobot) {
        robot.turnGunTo(robot.scannedAngle)
        robot.fire(1.0)
    }

    override fun onHitByBullet(robot: JuniorRobot) {
        robot.turnGunTo(robot.hitByBulletAngle)
        robot.fire(1.0)
        hits++
        if (hits > 5) {
            hits = 0
            robot.turnBackLeft(100, 90 - robot.hitByBulletBearing)
        }
    }

    override fun onHitWall(robot: JuniorRobot) {
        robot.turnBackRight(50, 90)
    }

    override fun onHitRobot(robot: JuniorRobot) {
        robot.turnGunTo(robot.hitRobotBearing)
        if (robot.energy > 1) robot.fire(3.0)
        robot.back(50)
    }
}