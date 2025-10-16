package aspitia.mattei.kotlin

import robocode.JuniorRobot


class LuckySpawn : JuniorRobot() {
    private var strategy: BattleStrategy = GridWalker()

    override fun run() {
        this.setColors(black, blue, red, red, black)
        strategy.run(this)
    }

    override fun onScannedRobot() {
        strategy.onScannedRobot(this)
    }

    override fun onHitByBullet() {
        strategy.onHitByBullet(this)
    }

    override fun onHitWall() {
        strategy.onHitWall(this)
    }

    override fun onHitRobot() {
        strategy.onHitRobot(this)
    }
}