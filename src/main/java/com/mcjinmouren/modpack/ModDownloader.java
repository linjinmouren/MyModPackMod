package com.mcjinmouren.modpack;

import com.mcjinmouren.modpack.api.FileDownloader;
import com.mcjinmouren.modpack.api.FileZipUtils;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.File;
import java.io.IOException;

public class ModDownloader {

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event){
        if (ModPackConfig.enableFastLinkForChina){
            try {
                FileZipUtils.ensureTempFolderExists();

                String[] DownloadURLFromOneDrive = {"http://storage.live.com/items/54E7C3B03AEFB78B!764:/modpackmods-all.zip?authkey=AG1K-ogAWv5U46E"};
                String Temp = FileZipUtils.TEMP_DIR + File.separator + "modpackmods-all.zip";
                String UnzipDir = "mods";

                FileDownloader.downloadFile(DownloadURLFromOneDrive, Temp);

            //    FileZipUtils.unzip(Temp, UnzipDir);
                ModPack.LOGGER.info("File Processed successfully.");
            } catch (IOException e) {
                ModPack.LOGGER.error("Error Processing file.");
                throw new RuntimeException(e);
            }
        }
    }

}