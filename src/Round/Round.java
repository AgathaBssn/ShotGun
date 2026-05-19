package src.Round;
import src.Playable.Playable;
import src.Bullet.Bullet;
import src.Bullet.EBulletType;
import src.Gun.Gun;

public class Round {
    private Playable player1;
    private Playable player2;
    private Playable currentPlayer;
    private Gun gun;
    
    public Round (Playable player1, Playable player2, Gun gun){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gun = gun;
    }

    public Playable getCurrentPlayer(){
        return this.currentPlayer;
    }

    public Playable getOpponent(Playable player) {
        if (player == player1) {
            return player2;
        }
        return player1;
    } 

    public boolean isFinished() {
        return gun.isEmpty() || !player1.isAlive() || !player2.isAlive();
    }

    public void changeTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public ShotResult resolveShot(Playable shooter, Playable target) {
        //get the bullet
        Bullet bullet = gun.shot();

        if (bullet == null) {
            return new ShotResult(null, target, 0, false);
        }

        int damage = 0;
        boolean turnContinue = false;

        if (bullet.getType() == EBulletType.REAL) {
            damage = 1;
            target.addHealthPoint(-damage);
        } else {
            //shot yourself and not hurt 
            if (shooter == target) {
                turnContinue = true;
            }
        }

        return new ShotResult(bullet, target, damage, turnContinue);
    }
}
