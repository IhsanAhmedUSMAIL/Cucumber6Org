package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _08_DataTableOrnek {
    @When("write username {string}")
    public void writeUsername(String userName) {
    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String userName, String password) {

        System.out.println("userName = " + userName);
        System.out.println("password = " + password);

    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable userlar) {
        List<String> listUserlar = userlar.asList(String.class); // liste

        for (String user : listUserlar)
            System.out.println("user = " + user);
    }

    @And("Write username and Password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable kullaniciVesifreler) {
        List< List<String> > listKullaniciVeSifreler = kullaniciVesifreler.asLists(String.class); // listelerin listesi

        for (int i = 0; i < listKullaniciVeSifreler.size(); i++) {
            System.out.println("listKullaniciVeSifreler = " + listKullaniciVeSifreler.get(i).get(0)+" "+ // username
                                                              listKullaniciVeSifreler.get(i).get(1)); // password
        }

    }
}
