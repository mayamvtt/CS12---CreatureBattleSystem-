public class Adam extends Creature{
    public Adam() {
        this.name = "Adam";
        this.health = 100000;
    }

    @Override
    public float attack() {
        int missChance = Rand.randomInt(0, 1000);
        if (missChance < 990) {
            return 0;
        }
        else {
            return 10000; // second impact moment
        }
    }

    @Override
    public void defend(float incomingPower) {

        // 5% chance of reducing damage taken (because he's literally the seed of life lmao)
        if (Rand.randomInt(0, 100) < 5) {
            incomingPower = 0;
            action = name + " absorbed it all. It did not affect him.";
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }
}
