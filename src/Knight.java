public class Knight extends Creature {
    public Knight(){
        this.name = "Knight";
        this.health = 100;
    }

    @Override
    public float attack() {
        int missChance = Rand.randomInt(1, 10);
        if (missChance < 4) {
            return 0;
        } else {
            float power = 0;
            int attackSelection = Rand.randomInt(1, 4);
            switch (attackSelection) {
                // Additional Attack selection
                case 1: // Slash
                    power = Rand.randomFloat(15, 20);
                    action = name + " slashed with power " + power + "!";
                case 2: // Cut
                    power = Rand.randomFloat(1,5);
                    action = name + " cut with power " + power + "!";
                case 3: // Smack with shield
                    power = Rand.randomFloat(5,10);
                    action = name + "smacked with his shield with power " + power + "!";
                case 4: // Stab
                    power = Rand.randomFloat(10,30);
                    action = name + " stabbed with power " + power + "!";
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
                        action = name + " parried with no damage taken!";
                    case 2: // Block
                        incomingPower = incomingPower * 0.2F;
                        action = name + " blocked! Reducing the damage to " + incomingPower + "!";
                    case 3: // Roll
                        incomingPower = incomingPower * 0.5F;
                        action = name + "rolled to dodge the attack! Reducing the damage to " + incomingPower + "!";
                }
        }
        else {
            action = name + " did not defend.";
        }
        health -= incomingPower;
    }
}
