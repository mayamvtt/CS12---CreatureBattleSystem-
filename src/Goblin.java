public class Goblin extends Creature{
    @Override
    public float attack() {

        // 10% chance of missing (because they are small and quick)
        if (Rand.randomInt(0, 10) < 1) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-15
        float power = Rand.randomFloat(10, 15);
        action = name + " grapples with power " + power + "!";
        return power;
    }

    @Override
    public void defend(float incomingPower) {

        // 50 % chance of dodging
        if (Rand.randomInt(0, 10) < 5) {
            incomingPower = 0;
            action = name + " dodged! " + name + " takes no damage! ";
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }
}
