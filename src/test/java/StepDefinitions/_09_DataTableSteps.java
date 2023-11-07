package StepDefinitions;

import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _09_DataTableStepss {
    LeftNav ln=new LeftNav();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strlinkList=linkler.asList(String.class);

        for (String strLink : strlinkList)
            ln.myClick(ln.getWebElement(strLink));



//        for(WebElement e: elementlerim)
//            dc.myClick(e);
    }
}
