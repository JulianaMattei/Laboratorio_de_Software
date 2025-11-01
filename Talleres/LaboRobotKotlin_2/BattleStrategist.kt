package aspitia.mattei
import robocode.JuniorRobot;

interface BattleStrategist {
    fun getOptimalStrategy(robot: JuniorRobot, strategy: BattleStrategy?): BattleStrategy
}

