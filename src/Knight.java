public class Knight extends Creature {
    public Knight(){
        super("Knight", 100);
    }

    @Override
    public float attack() {
        int missChance = Rand.randomInt(1, 10);
        if (missChance < 4) {
            setAction(getName() + " missed!");
            return 0;
        }
        else {
            float power = 0;
            int attackSelection = Rand.randomInt(1, 4);
            switch (attackSelection) {
                // Additional Attack selection
                case 1: // Slash
                    power = Rand.randomFloat(15, 20);
                    setAction(getName() + " slashed with power " + power + "!");
                    break;
                case 2: // Cut
                    power = Rand.randomFloat(1,5);
                    setAction(getName() + " cut with power " + power + "!");
                    break;
                case 3: // Smack with shield
                    power = Rand.randomFloat(5,10);
                    setAction(getName() + "smacked with his shield with power " + power + "!");
                    break;
                case 4: // Stab
                    power = Rand.randomFloat(10,30);
                    setAction(getName() + " stabbed with power " + power + "!");
                    break;
            }
            return power;
        }
    }

    @Override
    public void defend(float incomingPower) {
        int defendChance = Rand.randomInt(1,3);
        if (defendChance < 2) {
            int defenseSelection = Rand.randomInt(1,3);
                switch (defenseSelection){
                    case 1: // Parry
                        incomingPower = 0;
                        setAction(getName() + " parried with no damage taken!");
                    case 2: // Block
                        incomingPower = incomingPower * 0.2F;
                        setAction(getName() + " blocked! Reducing the damage to " + incomingPower + "!");
                    case 3: // Roll
                        incomingPower = incomingPower * 0.5F;
                        setAction(getName() + " rolled to dodge the attack! Reducing the damage to " + incomingPower + "!");
                }
        }
        else {
            setAction(getName() + " did not defend.");
        }
        reduceHealth(incomingPower);
    }
}
