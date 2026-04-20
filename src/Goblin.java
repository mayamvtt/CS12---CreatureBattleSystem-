public class Goblin extends Creature {
    public Goblin(){
        this.name = "Goblin";
        this.health = 75;
    }
    @Override
    public float attack() {
        int missChance = Rand.randomInt(1, 10);
        if (missChance < 1) {
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

        // 90 % chance of reducing damage taken (because of agility)
        if (Rand.randomInt(0, 10) < 9) {
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
