package src;

import java.util.Random;
import java.util.Scanner;

import src.Bullet.Bullet;
import src.Bullet.EBulletType;
import src.Gun.Gun;
import src.Playable.NPC;
import src.Playable.Player;
import src.Playable.Playable;
import src.Round.Round;
import src.Round.ShotResult;

public class Game {
    private Player player;
    private NPC npc;
    private Round currentRound;
    private ConsoleDisplay display;
    private Scanner scanner;
    private Random random;
    private int roundNumber;

    public Game(Player player, NPC npc, ConsoleDisplay display) {
        this.player = player;
        this.npc = npc;
        this.display = display;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
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


      public void play() {
        display.showGameStart();

        while (!isFinished()) {
            startNewRound();
            playRound();
            display.showRoundEnd(player, npc);
        }

        display.showWinner(getWinner());
        scanner.close();
    }

    private void playRound() {
        while (!currentRound.isFinished() && !isFinished()) {
            playTurn();
        }
    }

    private void playTurn() {
        Playable currentPlayer = currentRound.getCurrentPlayer();

        display.showRoundState(player, npc, currentPlayer);

        Playable target = chooseTarget(currentPlayer);
        ShotResult result = currentRound.resolveShot(currentPlayer, target);

        if (result.getBullet() == null) {
            display.showEmptyCharger();
            return;
        }

        display.showShotResult(result);

        if (!result.isTurnContinue()) {
            currentRound.changeTurn();
        }
    }

    private Playable chooseTarget(Playable currentPlayer) {
        if (currentPlayer instanceof Player) {
            return chooseTargetForPlayer(currentPlayer);
        } else {
            return chooseTargetForNpc(currentPlayer);
        }
    }

    private Playable chooseTargetForPlayer(Playable currentPlayer) {
        display.showPlayerChoices();
        int choice = scanner.nextInt();

        if (choice == 1) {
            return currentPlayer;
        } else if (choice == 2) {
            return currentRound.getOpponent(currentPlayer);
        }

        return null;
    }

    private Playable chooseTargetForNpc(Playable currentPlayer) {
        boolean shootSelf = random.nextBoolean();
        display.showNpcChoice(shootSelf);

        if (shootSelf) {
            return currentPlayer;
        }

        return currentRound.getOpponent(currentPlayer);
    }

}