package src.Gun;

import java.util.ArrayList;
import java.util.List;

import src.Bullet.Bullet;
import src.Bullet.EBulletType;

public class Gun {
    private List<Bullet> charger;

    public Gun() {
        this.charger = new ArrayList<>();
    }

    public void loadBullet(Bullet bullet) {
        this.charger.add(bullet);
    }

    public void loadSafeBullet() {
        this.charger.add(new Bullet(EBulletType.BLANK));
    }

    public void loadRealBullet() {
        this.charger.add(new Bullet(EBulletType.REAL));
    }

    public void emptyCharger() {
        this.charger.clear();
    }

    public List<Bullet> getCharger() {
        return charger;
    }

    public Bullet shot() {
        if (charger.isEmpty()) {
            return null;
        }
        // fifo bullet logic
        return charger.remove(0);
    }

    public boolean isEmpty() {
        return charger.isEmpty();
    }

    public int remainingBullets() {
        return charger.size();
    }

    
}