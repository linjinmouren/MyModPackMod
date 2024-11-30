package com.mcjinmouren.modpack.api;

import com.mcjinmouren.modpack.ModPack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileDownloader {

    public static void downloadFile (String[] fileURLs, String savePath) throws IOException {
        for (String fileURL : fileURLs){
            try (InputStream in = new URL(fileURL).openStream();
                 OutputStream out = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1){
                    out.write(buffer, 0,bytesRead);
                }
                ModPack.LOGGER.info("Downloaded successfully from: {}", fileURL);
                return;
            }catch (Exception e){
                ModPack.LOGGER.error("Failed to download from: {}", fileURL);
            }
        }
    }
}