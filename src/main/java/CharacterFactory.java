import lotr.Character;
import lotr.Noble;
import org.reflections.Reflections;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class CharacterFactory {
    Character createCharacter() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("lotr");
        Set<Class<?>> subTypes =
                reflections.get(SubTypes.of(Character.class).asClass());
        subTypes.remove(Noble.class);
        Class[] all_characters = new Class[subTypes.size()];
        int i = 0;
        for (Class x:
             subTypes) {
            all_characters[i++] = x;
        }
        int rnd = new Random().nextInt(all_characters.length);
        Constructor constr = all_characters[rnd].getConstructor();
        Character c = (Character) constr.newInstance();
        return c;
    }
}
