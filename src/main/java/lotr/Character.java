package lotr;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character{

    public Character(int hp, int power){
            setHp(hp);
            this.power = power;}
    @Setter
    private int power;

    private int hp;
    public void setHp(int hp){
        if (hp < 0){
            hp = 0;
        }
        this.hp = hp;
    }
    public void kick(Character c){
        setHp(c.getHp() - getPower());
    }
    public boolean isAlive(){
        return getHp() > 0;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "{hp="+this.getHp() +", power="+this.getPower()+"}";
    }
}
