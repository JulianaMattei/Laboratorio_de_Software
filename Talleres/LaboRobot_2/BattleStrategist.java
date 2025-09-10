package aspitia.mattei;

import robocode.JuniorRobot;

public interface BattleStrategist {
    BattleStrategy getOptimalStrategy(JuniorRobot robot, BattleStrategy strategy);
}
