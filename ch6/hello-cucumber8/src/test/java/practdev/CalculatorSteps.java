package practdev;

import cucumber.api.java8.En;
import static org.junit.Assert.*;
public class CalculatorSteps implements En{

    Calculator calc;
    public void CalculatorSteps() {
        Given("^I have entered (\\d+) into the calculator$", (Integer i) -> {
                System.out.format("Number entered: %n\n", i);
                calc.push(i);
            });
        
        Given("^I press add$", (String op) -> {
                System.out.format("operator entered: %n\n", op);
                calc.op(op);
            });
        Then("The result should be (\\d+)", (Integer i) -> {
                System.out.format("result : %n\n", i);
                //                assertThat(calc.result(),i);
            });
    
    }
}
