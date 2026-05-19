package src;

import src.ConsoleDisplay;
import src.Game;
import src.Playable.NPC;
import src.Playable.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Joueur");
        NPC npc = new NPC("Dealer");
        ConsoleDisplay display = new ConsoleDisplay();

        Game game = new Game(player, npc, display);
        game.play();
    }
}