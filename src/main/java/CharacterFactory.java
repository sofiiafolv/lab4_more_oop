import lotr.Noble;
import org.reflections.Reflections;

import java.util.Random;
import java.util.Set;

import static org.reflections.scanners.Scanners.SubTypes;

public class CharacterFactory {
    Class createCharacter(){
        Reflections reflections = new Reflections("com.my.project");
        Set<Class<?>> subTypes =
                reflections.get(SubTypes.of(Character.class).asClass());
        subTypes.remove(Noble.class);
        Class[] all_characters = new Class[subTypes.size()];
        int i = 0;
        for(Class x: subTypes) {
            all_characters[i] = x;
            i++;
        }
        int rnd = new Random().nextInt(all_characters.length);
        return all_characters[rnd];
    }
}
