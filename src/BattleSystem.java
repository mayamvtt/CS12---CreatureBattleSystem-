import java.sql.SQLOutput;

public class BattleSystem {
    public void battle(Creature a, Creature b) {
        while (a.getHealth() > 0 && b.getHealth() > 0) {
            float attackPower = a.attack();
            b.defend(attackPower);
            System.out.println(a.readAction());
            System.out.println(b.readAction());

            System.out.println(a);
            System.out.println(b);
            System.out.println();

            // swap turns
            Creature temp = a;
            a = b;
            b = temp;
        }
    }
}
