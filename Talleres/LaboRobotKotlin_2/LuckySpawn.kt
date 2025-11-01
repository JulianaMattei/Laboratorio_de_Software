package aspitia.mattei

import robocode.JuniorRobot

class LuckySpawn : JuniorRobot() {
    private var strategy: BattleStrategy? = null
    private val strategist: BattleStrategist = Strategist

    override fun run() {
        this.setColors(black, blue, red, red, black)
        this.strategy = strategist.getOptimalStrategy(this, strategy)
        strategy?.run(this)
    }

    override fun onScannedRobot() {
        this.strategy?.onScannedRobot(this)
    }

    override fun onHitByBullet() {
        this.strategy?.onHitByBullet(this)
    }

    override fun onHitWall() {
        this.strategy?.onHitWall(this)
    }

    override fun onHitRobot() {
        this.strategy?.onHitRobot(this)
    }
}