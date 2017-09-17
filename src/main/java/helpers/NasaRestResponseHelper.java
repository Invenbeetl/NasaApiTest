package helpers;

import dto.PhotoDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static util.ParseJsonUtil.getJsonArray;

public class NasaRestResponseHelper {

    public static final String PHOTOS_NODE = "photos";

    public List<PhotoDTO> handleRangeOfPhotosFromResponse(String response, int startRange, int endRange) {
        List<PhotoDTO> photosInfoList = new ArrayList<>();
        JSONArray jsonArrayFromResponse = getJsonArray(new JSONObject(response), PHOTOS_NODE);
        if (startRange < 0 || endRange > jsonArrayFromResponse.length()) {
            throw new IllegalArgumentException("Given range are out of photos array bounds");
        }
        collectInfoFromEachArrayObject(startRange, endRange, photosInfoList, jsonArrayFromResponse);
        return photosInfoList;
    }

    private void collectInfoFromEachArrayObject(int startRange, int endRange, List<PhotoDTO> photosList,
                                                JSONArray photosInfoArray) {
        for (int i = startRange; i < endRange; i++) {
            PhotoDTO photoDTO = new PhotoDTO();
            JSONObject innerJson = new JSONObject(photosInfoArray.get(i).toString());
            photoDTO.setId(innerJson.get("id").toString());
            photoDTO.setEarthDate(innerJson.get("earth_date").toString());
            photoDTO.setPhotoUri(innerJson.get("img_src").toString());
            photosList.add(photoDTO);
        }
    }
}
