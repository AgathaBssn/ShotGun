package src;

import src.Playable.Playable;
import src.Round.ShotResult;

public class ConsoleDisplay {

    public void showGameStart() {
        System.out.println("Partie lancée !");
    }

    public void showRoundState(Playable player, Playable npc, Playable currentPlayer) {
        System.out.println("\n-----***************------");
        System.out.println("Tour de : " + currentPlayer.getName());
        System.out.println(player.getName() + " HP : " + player.getHealthPoint());
        System.out.println(npc.getName() + " HP : " + npc.getHealthPoint());
    }

    public void showPlayerChoices() {
        System.out.println("Choisis une cible :");
        System.out.println("1 - Se tirer dessus");
        System.out.println("2 - Tirer sur l'adversaire");
    }


    public void showNpcChoice(boolean shootSelf) {
        if (shootSelf) {
            System.out.println("Le NPC choisit de se tirer dessus.");
        } else {
            System.out.println("Le NPC choisit de tirer sur son adversaire.");
        }
    }

    public void showEmptyCharger() {
        System.out.println("Le chargeur est vide.");
    }

    public void showShotResult(ShotResult result) {
        System.out.println("Balle tirée : " + result.getBullet().getType());
        System.out.println("Cible : " + result.getTarget().getName());
        System.out.println("Dégâts : " + result.getDamage());

        if (result.isTurnContinue()) {
            System.out.println("La balle était à blanc sur soi-même : le tour continue.");
        }
    }

    public void showRoundEnd(Playable player, Playable npc) {
        System.out.println("\n===== Fin de manche =====");
        System.out.println(player.getName() + " HP : " + player.getHealthPoint());
        System.out.println(npc.getName() + " HP : " + npc.getHealthPoint());
    }

    public void showWinner(Playable winner) {
        if (winner != null) {
            System.out.println("\n===== Fin de partie =====");
            System.out.println("Le gagnant est : " + winner.getName());
        }
    }
}