package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;

import java.lang.ref.SoftReference;

public class _02_CountrySteps {

    LeftNav ln= new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.countries);

    }

    @When("Create a country")
    public void createACountry() {
        String ulkeAdi= RandomStringUtils.randomAlphanumeric(8); //8 harf
        String ulkeKodu=RandomStringUtils.randomNumeric(4); //4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeyes(dc.nameInput, ulkeAdi);
        dc.mySendKeyes(dc.codeInput, ulkeKodu);
        dc.myClick(dc.saveButton);

    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed()
    {
        dc.verifyContainsText(dc.successMessage, "success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.myClick(dc.addButton);
        dc.mySendKeyes(dc.nameInput, name);
        dc.mySendKeyes(dc.codeInput, code);
        dc.myClick(dc.saveButton);

    }
}
