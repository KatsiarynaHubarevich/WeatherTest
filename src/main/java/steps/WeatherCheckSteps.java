package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.*;
import static utils.TestDataHelper.*;

public class WeatherCheckSteps {
    private String endpointURL = BASE_API_URL + "/find?lat={latitude}&lon={longitude}&cnt={count}&appid=" + API_KEY;

    private final float MIN_TEMP_CELSIUS = -100f;
    private final float MAX_TEMP_CELSIUS = 100f;
    private final int CITIES_COUNT = 10;

    private Response response;

    @Step
    public void searchCitiesInCircle(){
        response = SerenityRest.
                given().
                    pathParam("latitude", getRandomLatitude()).
                    pathParam("longitude", getRandomLongitude()).
                    pathParam("count", CITIES_COUNT).
                when().
                    get(endpointURL);
    }

    @Step
    public void isSearchExecutedSuccesfully(){
        response.
                then().
                    statusCode(200);
    }

    @Step
    public void isWeatherInCorrectRange(){
        response.
                then().
                    body("list.main.temp", everyItem(is(both(greaterThan(fromCelsiusToKelvin(MIN_TEMP_CELSIUS))).and(lessThan(fromCelsiusToKelvin(MAX_TEMP_CELSIUS))))));
    }
}
