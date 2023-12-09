import java.util.*;
import java.lang.reflect.Field;
public class Monster {
    String eyesColor, featherColor, magicalAbility;
    int size, strength, durability, weakness, agression;

    public String getEyesColor() {
        return eyesColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    public String getMagicalAbility() {
        return magicalAbility;
    }

    public void setMagicalAbility(String magicalAbility) {
        this.magicalAbility = magicalAbility;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getWeakness() {
        return weakness;
    }

    public void setWeakness(int weakness) {
        this.weakness = weakness;
    }

    public int getAgression() {
        return agression;
    }

    public void setAgression(int agression) {
        this.agression = agression;
    }
    public Monster(){

    }
    public Monster(String eyesColor, String featherColor, String magicalAbility, int size, int strength, int durability, int weakness, int agression) {
        this.eyesColor = eyesColor;
        this.featherColor = featherColor;
        this.magicalAbility = magicalAbility;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.agression = agression;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "eyesColor='" + eyesColor + '\'' +
                ", featherColor='" + featherColor + '\'' +
                ", magicalAbility='" + magicalAbility + '\'' +
                ", size=" + size +
                ", strength=" + strength +
                ", durability=" + durability +
                ", weakness=" + weakness +
                ", agression=" + agression +
                '}';
    }

    public static Monster createRandomClass(Monster obj1, Monster obj2){
        Random random= new Random();
        Monster randomObject= new Monster();
        try{
            Field[] fields=Monster.class.getDeclaredFields();

            for(Field field: fields){
                field.setAccessible(true);
                Object val1=field.get(obj1);
                Object val2=field.get(obj2);

                if(field.getType()==int.class){
                    field.set(randomObject,random.nextBoolean()?val1:val2);
                } else if (field.getType()==String.class) {
                    field.set(randomObject,random.nextBoolean()?val1:val2);
                }

            }
        }
        catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return randomObject;
    }
}
