package src.Bullet;

public class Bullet {
    private EBulletType type;

    public Bullet(EBulletType type) {
        this.type = type;
    }

    public EBulletType getType() {
        return type;
    }

    public EBulletType getBulletType(){
        return this.type;
    }
}
