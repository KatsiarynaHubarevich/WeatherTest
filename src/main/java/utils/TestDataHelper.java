package utils;

public class TestDataHelper {
    public static final String BASE_API_URL = "http://api.openweathermap.org/data/2.5";
    public static final String API_KEY = "789eac49f36c568dd7a0b197b496d654";

    private static final double MAX_LATITUDE = 90;
    private static final double MAX_LONGITUDE = 180;

    public static float fromCelsiusToKelvin(Float number) {
        return number + (float) 273.15;
    }

    public static double getRandomValue(double max) {
        return Math.random() * ++max;
    }

    public static double getRandomLatitude(){
        return  getRandomValue(MAX_LATITUDE);
    }

    public static double getRandomLongitude(){
        return  getRandomValue(MAX_LONGITUDE);
    }

}
