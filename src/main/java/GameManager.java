import lotr.Character;
import lotr.Hobbit;

import java.lang.reflect.InvocationTargetException;

public class GameManager {
    void fight(Character c1, Character c2){
        String name_of_c1 = c1.getClass().getSimpleName().toUpperCase();
        String name_of_c2 = c2.getClass().getSimpleName().toUpperCase();
        System.out.println(name_of_c1 + " vs. " +name_of_c2+"\n");
        System.out.println(name_of_c1 +": power - "+c1.getPower()+", hp - "+c1.getHp());
        System.out.println(name_of_c2 +": power - "+c2.getPower()+", hp - "+c2.getHp()+"\n");
        System.out.println("3... 2... 1... Fight!");
        if(c1 instanceof Hobbit && c2 instanceof Hobbit){
            System.out.println("It's a draw. Two Hobbits can't fight.");
        }
        else {
            int i = 1;
            while (c1.isAlive() && c2.isAlive()) {
                c1.kick(c2);
                if (c2.isAlive()) c2.kick(c1);
                System.out.println("HP of fighters after "+i+" round:");
                System.out.println(name_of_c1+": "+c1.getHp());
                System.out.println(name_of_c2+": "+c2.getHp()+"\n");
                i++;
            }
            if (c1.isAlive()) System.out.println(name_of_c1+" won. Congratulations\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
            else System.out.println(name_of_c2+" won. Congratulations\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CharacterFactory charfac = new CharacterFactory();
        GameManager gm = new GameManager();
        gm.fight(charfac.createCharacter(), charfac.createCharacter());
    }
}
