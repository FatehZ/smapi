package com.ktxdevelopment.siratumustakim.util.img;

import java.io.IOException;
import java.util.Base64;

public class ImageUtils {
    private static byte[] downloadImage(String imageUrl) throws IOException {
        return null;
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet(imageUrl);
//        HttpResponse response = httpClient.execute(httpGet);
//        HttpEntity entity = response.getEntity();
//        return IOUtils.toByteArray(entity.getContent());
    }

    private static String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static String imageToBase64(String imageUrl) throws IOException {
        byte[] image = downloadImage(imageUrl);
        return convertToBase64(image);
    }
}