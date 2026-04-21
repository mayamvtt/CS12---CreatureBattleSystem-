public class Goblin extends Creature {
    public Goblin(){
        this.name = "Goblin";
        this.health = 75;
    }
    @Override
    public float attack() {
        int missChance = Rand.randomInt(1, 10);
        if (missChance < 1) {
            action = name + " missed!";
            return 0;
        }
        else {
            float power = 0;
            int attackSelection = Rand.randomInt(1, 3);
            switch (attackSelection) {
                // Additional Attack selection
                case 1: // Grapple
                    power = Rand.randomFloat(0, 5);
                    action = name + " grappled with power " + power + "!";
                case 2: // Kick
                    power = Rand.randomFloat(2,4);
                    action = name + " kicked with power " + power + "!";
                case 3: // Punch
                    power = Rand.randomFloat(5,10);
                    action = name + "punched with power " + power + "!";
            }
            return power;
        }
    }

    @Override
    public void defend(float incomingPower) {
        int defendChance = Rand.randomInt(1,4);
        if (defendChance < 3) {
            int defenseSelection = Rand.randomInt(1,2);
            switch (defenseSelection){
                case 1: // Roll
                    incomingPower = 0;
                    action = name + " rolled with no damage taken!";
                case 2: // Dash
                    incomingPower = incomingPower * 0.5F;
                    action = name + " dashed! Reducing damage to " + incomingPower + "!";
            }
        }
        else {
            action = name + " did not defend.";
        }
        health -= incomingPower;
    }
}
