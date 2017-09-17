package helpers;

import dto.PhotoDTO;

import java.util.List;

public class PhotosDataComparisionHelper {

    public boolean arePhotosDataFromListsEqual (List<PhotoDTO> firstList, List<PhotoDTO> secondList) {
        for (int i = 0; i < firstList.size(); i++) {
            boolean equality = (firstList.get(i).getId().equals(secondList.get(i).getId())
                    && firstList.get(i).getEarthDate().equals(secondList.get(i).getEarthDate())
                    && firstList.get(i).getPhotoSize() == secondList.get(i).getPhotoSize());
            if (!equality) {
                return false;
            }
        }
        return true;
    }
}
