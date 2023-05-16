package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.TaxFeeValidation;
import static org.junit.Assert.*;

public class TaxFeeValidationSteps {

    private TaxFeeValidation taxFeeValidation = new TaxFeeValidation();

    @And("User fill address data {string} {string} {string} {string}")
    public void userFillAddress(String address, String state, String city, String zipCode) {
        taxFeeValidation.fillAddressData(address, state, city, zipCode);
    }

    @And("User move to Add payment detail page")
    public void userMoveToAddPaymentDetailPage() {
        taxFeeValidation.moveToAddPaymentMethod();
    }

    @Then("User check the tax fee {string}")
    public void userCheckTheTaxFee(String taxPercent) {
        Double taxValue = Double.valueOf(taxPercent);
        assertEquals(taxValue, taxFeeValidation.taxPercentValue());
    }
}
