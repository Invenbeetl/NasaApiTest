package helpers;

import util.DateTimeUtil;
import util.NasaRestUtil;

public class ReceiveNasaPhotosHelper {

    private static final String CURIOSITY_ROVER_NAME = "curiosity";
    public static final String CURIOSITY_LANDING_DATE = "2012-8-6";
    public static final double SOL_TO_EARTH_DAYS_CONVERTION_INDEX = 1.02749125170;

    public String getCuriosityPhotosAtSpecifiedSol(String sol) {
        return NasaRestUtil.getPhotosFromSpesifiedRoverBySolDate(CURIOSITY_ROVER_NAME, sol);
    }

    public String getCuriosityPhotosAtSpecifiedEarthDateBySol(String sol) {
        Double earthDaysInSols = Double.valueOf(sol) * SOL_TO_EARTH_DAYS_CONVERTION_INDEX;
        int integerConvertedDays = earthDaysInSols.intValue();
        String earthDate = DateTimeUtil.getDatePlusDays(CURIOSITY_LANDING_DATE, integerConvertedDays);
        return NasaRestUtil.getPhotosFromSpecifiedRoverByEarthDate(CURIOSITY_ROVER_NAME, earthDate);
    }
}
