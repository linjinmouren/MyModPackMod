package com.mcjinmouren.modpack.api;

import com.mcjinmouren.modpack.ModPack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileZipUtils {

    public static final String TEMP_DIR = "temp";

    public static void  ensureTempFolderExists() throws IOException{
        Path tempFolderPath = Paths.get(TEMP_DIR);
        if (!Files.exists(tempFolderPath)){
            Files.createDirectories(tempFolderPath);
        }
    }

    public static void unzip(String zipFilePath, String destDirectory) throws IOException{
        ensureTempFolderExists();
        Files.createDirectories(Paths.get(destDirectory));
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))){
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null){
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()){
                    extractFile(zipIn, filePath);
                } else {
                    Files.createDirectories(Paths.get(filePath));
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
        deleteFile(zipFilePath);
    }

    private static void extractFile(InputStream zipIn, String filePath) throws IOException{
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))){
            byte[] bytesIn = new byte[4096];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1){
                bos.write(bytesIn, 0, read);
            }
        }
    }

    public static void deleteFile(String filePath){
        try {
            Files.delete(Paths.get(filePath));
            ModPack.LOGGER.info("Deleted original file: {}", filePath);
        } catch (IOException e){
            ModPack.LOGGER.error("Error deleting file: {}", filePath);
            throw new RuntimeException(e);
        }
    }

}
