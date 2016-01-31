package practdev;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;
public class CalculatorSteps{

    Calculator calc;

    @Given("^I have entered (\\d+) into the calculator$")
    public void a(Integer i){
        System.out.format("Number entered: %n\n", i);
        //        calc.push(i);
    };
        
    @Given("^I press (\\w+)")
    public void b(String op){
        System.out.format("operator entered: %n\n", op);
        //        calc.op(op);
    };
    @Then("The result should be (\\d+)")
    public void c(Integer i){
        System.out.format("result : %n\n", i);
                //                assertThat(calc.result(),i);
    }
    
}
