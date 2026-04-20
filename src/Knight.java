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
                    action = name + "stabbed with power " + power + "!";
            }
            return power;
        }
    }

    @Override
    public void defend(float incomingPower) {

        // 30 % chance of reducing damage taken (because sword makes it easy to fight)
        if (Rand.randomInt(0, 10) < 3) {
            incomingPower = 0;
            action = name + " parried and fully dodged the attack!";
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }
}
