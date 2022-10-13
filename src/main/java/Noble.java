import java.util.Random;

public abstract class Noble  extends Character{
        private static final Random randomGenerator = new Random();
        public Noble(int max, int min){
            super(randomGenerator.nextInt(max - min) + min, randomGenerator.nextInt(max - min) + min);
        }

        @Override
        public void kick(Character c){
            c.setHp(c.getHp() - randomGenerator.nextInt(getPower()));
        }
    }

