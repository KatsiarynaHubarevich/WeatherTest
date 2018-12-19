package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.WeatherCheckSteps;

@RunWith(SerenityRunner.class)
public class WeatherCheckTest {

    @Steps

    WeatherCheckSteps weatherCheckSteps;

    @Test
    public void verifyWeatherByCitiesLocation() {
        weatherCheckSteps.searchCitiesInCircle();
        weatherCheckSteps.isSearchExecutedSuccesfully();
        weatherCheckSteps.isWeatherInCorrectRange();
    }
}
