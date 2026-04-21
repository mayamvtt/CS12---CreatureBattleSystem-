public class Main {
    public static void main(String[] args) {

        // set up the creatures
        Creature a = new Goblin();
        Creature b = new Knight();

        // set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // run the battle
        battleSystem.battle(a, b);
    }
}
