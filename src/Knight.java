public class Knight extends Creature {
    @Override
    public float attack() {

        // 40% chance of missing (because the weight of the sword)
        if (Rand.randomInt(0, 10) < 4) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-40 (because it's a sword lmao)
        float power = Rand.randomFloat(10, 40);
        action = name + " cut with power " + power + "!";
        return power;
    }

    @Override
    public void defend(float incomingPower) {

        // 50 % chance of reducing damage taken (because sword makes it easy to fight)
        if (Rand.randomInt(0, 10) < 5) {
            incomingPower = incomingPower * 0.5f;
            action = name + " parried and reduced damage taken to " + incomingPower;
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }
}
