package aspitia.mattei;
import robocode.JuniorRobot;

public class LuckySpawn extends JuniorRobot
{
    BattleStrategy strategy;

    public LuckySpawn() {
        super();
        this.strategy = new GridWalker();
    }

	public void run() {
        this.setColors(black, blue, red, red, black);
        strategy.run(this);
	}

	public void onScannedRobot() {
        strategy.onScannedRobot(this);
	}

	public void onHitByBullet() {
        strategy.onHitByBullet(this);
	}

	public void onHitWall() {
        strategy.onHitWall(this);
	}

    public void onHitRobot() {
        strategy.onHitRobot(this);
    }
}