package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D:\\AT2\\src\\test\\java\\scenarios",
        glue = "steps",
        tags = "@4"
)
public class Runner {

    @Test
    public static void run(String[] args) {

    }
}
