package src;

import src.Bullet.Bullet;
import src.Bullet.EBulletType;
import src.Gun.Gun;
import src.Playable.NPC;
import src.Playable.Player;
import src.Playable.Playable;
import src.Round.Round;

public class Game {
    private Player player;
    private NPC npc;
    private Round currentRound;

    public Game(Player player, NPC npc) {
        this.player = player;
        this.npc = npc;
    }

    public Player getPlayer() {
        return player;
    }

    public NPC getNpc() {
        return npc;
    }

    public Round getCurrentRound() {
        return currentRound;
    }

    public boolean isFinished() {
        return !player.isAlive() || !npc.isAlive();
    }

    public Playable getWinner() {
        if (player.isAlive() && !npc.isAlive()) {
            return player;
        }
        if (npc.isAlive() && !player.isAlive()) {
            return npc;
        }
        return null;
    }

    public void startNewRound() {
        Gun gun = new Gun();

        // load charger
        gun.loadBullet(new Bullet(EBulletType.REAL));
        gun.loadBullet(new Bullet(EBulletType.BLANK));
        gun.loadBullet(new Bullet(EBulletType.REAL));
        gun.loadBullet(new Bullet(EBulletType.BLANK));
        gun.loadBullet(new Bullet(EBulletType.REAL));
        gun.loadBullet(new Bullet(EBulletType.BLANK));

        this.currentRound = new Round(player, npc, gun);
    }
}