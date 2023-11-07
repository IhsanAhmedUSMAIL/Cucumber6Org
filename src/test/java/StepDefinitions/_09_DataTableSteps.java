package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _09_DataTableSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strlinkList=linkler.asList(String.class);

        for (int i = 0; i< strlinkList.size(); i++) {
            ln.myClick(ln.getWebElement(strlinkList.get(i)));
        }

    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable buttons) {
        List<String> strButtonsList=buttons.asList(String.class);

        for (int i = 0; i< strButtonsList.size(); i++) {
            dc.myClick(dc.getWebElement(strButtonsList.get(i)));
        }

    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dt) {
        List<List<String> >  items = dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement e=dc.getWebElement(items.get(i).get(0)); // 0. webelement
            String yazi = items.get(i).get(1); // 1. yazısı

            dc.mySendKeyes(e, yazi);
        }
    }


    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dt) {
        List<String> silinecekler = dt.asList(String.class);

        for (int i = 0; i < silinecekler.size(); i++) {
            dc.deleteItem(silinecekler.get(i));
        }
    }
}
