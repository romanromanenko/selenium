package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.Checkout;

public class CheckoutSteps {

    private Checkout checkout = new Checkout();

    @And("User open details of item")
    public void userOpenDetailsOfItem() {
        checkout.openDetails();
    }

    @And("User add item to cart")
    public void userAddItemToCart() {
        checkout.addItemToCart();
    }

    @And("User move to checkout")
    public void userMoveToCard() {
        checkout.moveToCheckout();
    }

    @And("User click add payment detail button")
    public void userClickAddPaymentDetailButton() {
        checkout.clickOnAddPaymentDetailsButton();
    }

    @And("User click on place order button")
    public void userClickOnPlaceOrderButton() {
        checkout.clickOnPlaceOrderButton();
    }

    @And("User continue checkout as a guest")
    public void userContinueCheckoutAsAGuest() {
        checkout.continueAsGuest();
    }

    @And("User fill shipping address and email")
    public void userFillShippingAddressAndEmail() {
        checkout.fillShippingAddress();
    }

    @And("User fill payment details")
    public void userFillPaymentDetails() {
        checkout.fillPaymentDetails();
    }

    @And("User item to wishlist")
    public void userItemToWishlist() {
        checkout.addItemToWishList();
    }

    @Then("User see order description")
    public void userSeeMessage() {
        Assertions.assertThat(checkout.getActualMessageAfterOrderPlacement()).isTrue();
    }

    @And("User open Quick View form")
    public void userOpenQuickViewForm() {
        checkout.openQuickViewForm();
    }

    @And("User add item to cart from Quick View form")
    public void userAddItemToCartFromQuickViewForm() {
        checkout.addItemToCartFromQuickViewForm();
    }

    @And("User select Afterpay as pay method")
    public void userSelectAfterpayAsPayMethod() {
        checkout.selectAfterpay();
    }

    @And("User confirm test transaction")
    public void userConfirmTestTransaction() {
        checkout.confirmTestTransaction();
    }
}
