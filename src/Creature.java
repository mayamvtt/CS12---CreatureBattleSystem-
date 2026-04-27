public class Creature {
    private String name;
    private float health;
    private String action;

    public Creature(String name, float health){
        this.name = name;
        this.health = health;
    }

    // Returns the damage done by the Creature
    public float attack() {
        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            action = name + " missed!";
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(10, 20);
        action = name + " attacked with power " + power + "!";
        return power;
    }

    public void defend(float incomingPower) {

        // 10 % chance of reducing damage taken
        if (Rand.randomInt(0, 10) < 1) {
            incomingPower = incomingPower * 0.8f;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
        {
            action = name + " did not defend.";
        }

        health -= incomingPower;
    }

    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }

    // Getters and "Setters"
    public float getHealth() {
        return this.health;
    }

    public String getName() {
        return this.name;
    }

    public String getAction() {
        return this.action;
    }

    protected void setAction(String action) {
        this.action = action;
    }

    public void reduceHealth(float power){
        this.health -= power;
    }


}
