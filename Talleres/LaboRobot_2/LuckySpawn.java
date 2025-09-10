package aspitia.mattei;

import robocode.JuniorRobot;

public class LuckySpawn extends JuniorRobot {
    BattleStrategy strategy;
    BattleStrategist strategist;

    public LuckySpawn() {
        super();
        this.strategist = Strategist.getStrategist();
    }

    @Override
    public void run() {
        this.setColors(black, blue, red, red, black);
        this.strategy = strategist.getOptimalStrategy(this, strategy);
        strategy.run(this);
    }

    @Override
    public void onScannedRobot() {
        this.strategy.onScannedRobot(this);
    }

    @Override
    public void onHitByBullet() {
        this.strategy.onHitByBullet(this);
    }

    @Override
    public void onHitWall() {
        this.strategy.onHitWall(this);
    }

    @Override
    public void onHitRobot() {
        this.strategy.onHitRobot(this);
    }
}
