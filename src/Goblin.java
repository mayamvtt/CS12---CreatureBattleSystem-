public class Goblin extends Creature {
    public Goblin(){
        super("Goblin", 75);
    }

    @Override
    public float attack() {
        int missChance = Rand.randomInt(1, 10);
        if (missChance < 1) {
            setAction(getName() + " missed!");
            return 0;
        }
        else {
            float power = 0;
            int attackSelection = Rand.randomInt(1, 3);
            switch (attackSelection) {
                // Additional Attack selection
                case 1: // Grapple
                    power = Rand.randomFloat(0, 5);
                    setAction(getName() + " grappled with power " + power + "!");
                    break;
                case 2: // Kick
                    power = Rand.randomFloat(2,4);
                    setAction(getName() + " kicked with power " + power + "!");
                    break;
                case 3: // Punch
                    power = Rand.randomFloat(5,10);
                    setAction(getName() + " power with power " + power + "!");
                    break;
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
                    setAction(getName() + " rolled with no damage taken");
                    break;
                case 2: // Dash
                    incomingPower *= 0.5F;
                    setAction(getName() + " dashed! Reducing damage to " + incomingPower);
                    break;
            }
        }
        else {
            setAction(getName() + " did not defend");
        }
        reduceHealth(incomingPower);
    }
}
