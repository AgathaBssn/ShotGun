package src.Round;

import src.Bullet.Bullet;
import src.Playable.Playable;

public class ShotResult {
    private Bullet bullet;
    private Playable target;
    private int damage;
    private boolean turnContinue;

    public ShotResult(Bullet bullet, Playable target, int damage, boolean turnContinue) {
        this.bullet = bullet;
        this.target = target;
        this.damage = damage;
        this.turnContinue = turnContinue;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public Playable getTarget() {
        return target;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isTurnContinue() {
        return turnContinue;
    }
}