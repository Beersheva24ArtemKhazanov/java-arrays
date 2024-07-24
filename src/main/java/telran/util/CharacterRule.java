package telran.util;

import java.util.function.Predicate;

public class CharacterRule {
    public boolean flag;
    public Predicate<Character> predicate;
    public String errorMessage;

    public CharacterRule(boolean flag, Predicate<Character> predicate, String errorMessage) {
        this.flag = flag;
        this.predicate = predicate;
        this.errorMessage = errorMessage;
    }

    public boolean isValid(char item) {
        boolean result = predicate.test(item);
        return flag ? result : !result;
    }
}