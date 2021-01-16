package steps;

import io.cucumber.java.ru.Тогда;
import java.util.HashMap;

public class StepDefs {
    static HashMap<String,Integer> storage = new HashMap<>();

    @Тогда("у меня есть {int} огурца")
    public static void getMyCukes(int num) {
        System.out.println("У меня "+num+" огурцов");
        storage.put("Мои огурцы",num);
    }

    @Тогда("у тебя {int} огурца")
    public static void getYourCukes(int num) {
        System.out.println("У тебя "+num+" огурцов");
        storage.put("Твои огурцы",num);
    }

    @Тогда("сосчитать сколько у нас огурцов")
    public static void countCukes() {
        System.out.println("У нас "+(storage.get("Мои огурцы")+storage.get("Твои огурцы"))+" огурцов");
    }
}
