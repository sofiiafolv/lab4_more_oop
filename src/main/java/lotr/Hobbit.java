package lotr;

public class Hobbit extends Character {
    public Hobbit(){
        super(3, 0);
    }
    @Override
    public void kick(Character c){
        super.kick(c);
        toCry();
    }

    private void toCry(){
        System.out.println("\uD83D\uDE22\uD83D\uDE22\uD83D\uDE22");
    }

}
