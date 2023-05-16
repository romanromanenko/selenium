package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;


public class StartPageSteps {
    private HomePage homePage = new HomePage();

    @Given("Open app")
    public void openApp() {
        homePage.start();
    }

    @Given("User login with credentials {string} {string}")
    public void userLoginWithCredentials(String email, String password) {
        homePage.login(email, password);
    }

    @When("User click on search icon")
    public void userClickOnSearchIcon() {homePage.clickOnSearchIcon();}

    @And("User search {string}")
    public void userSearch(String itemName) {homePage.itemSearch(itemName);}

    @And("User log out")
    public void userLogOut() {homePage.logOut();}

    @When("User open catalog")
    public void userOpenCatalog() {homePage.openCatalog();}

    @And("User switch to Art tab")
    public void userSwitchToArtTab() {homePage.switchToArtTab();}

    @And("User open Wishlist page")
    public void userOpenWishlistPage() {homePage.openWishList();
    }
}
