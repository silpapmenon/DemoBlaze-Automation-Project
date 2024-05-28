package bddFramework_CucumberTool;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\AddProduct.feature", glue="bddFramework_CucumberTool",
monochrome = true,
plugin= {"pretty", "html:src/test/resources/AddToCart.html",
		"json:src/test/resources/AddToCart.json",
		"junit:src/test/resources/AddToCart.junit"
}
)
public class TestRunner 
{

}