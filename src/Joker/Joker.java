package src.Joker;

import java.util.Random;

public class Joker {
    private ETypeJoker typeJoker;

    public Joker(ETypeJoker typeJoker) {
        this.typeJoker = typeJoker;
    }

    public Joker() {
        this.typeJoker = randomEnum(ETypeJoker.class);
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public ETypeJoker getTypeJoker() {
        return typeJoker;
    }
}