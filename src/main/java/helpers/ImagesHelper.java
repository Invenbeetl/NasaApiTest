package helpers;

import dto.PhotoDTO;
import org.apache.commons.lang3.RandomUtils;

import java.io.*;
import java.net.URL;
import java.util.List;

public class ImagesHelper {

    public static final String PATH_TO_DOWNLOADS_DIR = "/src/test/resources/downloads/";

    public void handleImagesFromList (List<PhotoDTO> imagesInfoList) {
        for (PhotoDTO photoDTO : imagesInfoList) {
            photoDTO.setPhotoSize(getSizeOfDownloadedImage(photoDTO.getPhotoUri()));
        }
    }

    public long getSizeOfDownloadedImage(String stringUrl) {
        final File file = new File(normalizePathToProjectRootDir() + PATH_TO_DOWNLOADS_DIR
                + generateName());
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }
            URL url = new URL(stringUrl);
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();

            fileOutputStream.write(response);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file.length();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to write data to file " + e);
        }
    }

    private String normalizePathToProjectRootDir() {
        String path = System.getProperty("user.dir");
        return path.replace("\\","/");
    }

    private String generateName() {
        return "img_" + RandomUtils.nextInt(0,999999) + ".jpg";
    }
}
