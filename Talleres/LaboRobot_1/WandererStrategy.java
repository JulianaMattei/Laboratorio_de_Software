package aspitia.mattei;

import robocode.JuniorRobot;

public class WandererStrategy implements BattleStrategy {

    private int hits = 0;
    private boolean sweepRight = true;

    @Override
    public void run(JuniorRobot robot) {
        while (true) {
            robot.turnAheadRight(30, 30);
            robot.ahead(20);
            robot.turnAheadLeft(30, 30);
            robot.turnGunRight(360);
        }
    }

    @Override
    public void onScannedRobot(JuniorRobot robot) {
        robot.turnGunTo(robot.scannedAngle);
        robot.fire(1);
    }

    @Override
    public void onHitByBullet(JuniorRobot robot) {
        robot.turnGunTo(robot.hitByBulletAngle);
        robot.fire(1);
        hits++;
        if (hits > 5) {
            hits = 0;
            robot.turnBackLeft(100, 90 - robot.hitByBulletBearing);
        }
    }

    @Override
    public void onHitWall(JuniorRobot robot) {
        robot.turnBackRight(50, 90);
    }

    @Override
    public void onHitRobot(JuniorRobot robot) {
        robot.turnGunTo(robot.hitRobotBearing);
        if (robot.energy > 1) robot.fire(3);
        robot.back(50);
    }
}