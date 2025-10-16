package aspitia.mattei.kotlin

import robocode.JuniorRobot


interface BattleStrategy {
    /**
     * run: entrypoint
     */
    fun run(robot: JuniorRobot)

    /**
     * onScannedRobot: What to do when you see another robot
     */
    fun onScannedRobot(robot: JuniorRobot)

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    fun onHitByBullet(robot: JuniorRobot)

    /**
     * onHitWall: What to do when you hit a wall
     */
    fun onHitWall(robot: JuniorRobot)

    /**
     * onHitRobot: What to do when you hit a robot
     */
    fun onHitRobot(robot: JuniorRobot)
}