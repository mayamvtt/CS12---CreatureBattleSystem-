public class Adam extends Creature{
    public Adam() {
        super("Adam", 100000);
    }

    @Override
    public float attack() {
        int missChance = Rand.randomInt(0, 1000);
        if (missChance < 990) {
            setAction(getName() + " missed!");
            return 0;
        }
        else {
            return 10000; // second impact moment
        }
    }

    @Override
    public void defend(float incomingPower) {

        // 5% chance of reducing damage taken (because he's literally the seed of life lmao)
        if (Rand.randomInt(0, 100) < 1) {
            incomingPower = 0;
            setAction(getName() + " absorbed it all. It did not affect him.");
        }
        else
        {
            setAction(getName() + " did not defend.");
        }

        reduceHealth(incomingPower);
    }
}
