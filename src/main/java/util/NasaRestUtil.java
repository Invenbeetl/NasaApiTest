package util;

public class NasaRestUtil {

    private static final String NASA_URI = "https://api.nasa.gov";
    private static String PHOTOS_BY_SOL_DATE_ENDPOINT =
            "/mars-photos/api/v1/rovers/%s/photos?sol=%s&api_key=DEMO_KEY";
    private static String PHOTOS_BY_EARTH_DATE_ENDPOINT =
            "/mars-photos/api/v1/rovers/%s/photos?earth_date=%s&api_key=DEMO_KEY";

    public static String getPhotosFromSpesifiedRoverBySolDate(String roverName, String date) {
        String uri = NASA_URI + String.format(PHOTOS_BY_SOL_DATE_ENDPOINT, roverName, date);
        return RestUtil.sendGetRequest(uri);
    }

    public static String getPhotosFromSpecifiedRoverByEarthDate(String roverName, String earthDate) {
        String uri = NASA_URI + String.format(PHOTOS_BY_EARTH_DATE_ENDPOINT, roverName, earthDate);
        return RestUtil.sendGetRequest(uri);
    }
}
