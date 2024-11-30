package com.mcjinmouren.modpack.compat;

import com.mcjinmouren.modpack.ModPack;
import com.mcjinmouren.modpack.ModPackConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FluxNetworks {

    @SubscribeEvent
    public void onCommonsetup(FMLLoadCompleteEvent event) throws IOException {
        if (!ModPackConfig.enableFluxNetworksRecipe){
            if (ModList.get().isLoaded("fluxnetworks")){
                File fluxnetworks = new File("defaultconfigs", "fluxnetworks-server.toml");
                if (!fluxnetworks.exists() && !fluxnetworks.createNewFile()){
                    ModPack.LOGGER.error(ModPack.ERROR_CREATEFILE);
                }
                try {
                    String Content = """
                            [networks]
                            maximumPerPlayer = 5
                            enableSuperAdmin = true
                            superAdminRequiredPermission = 1
                            
                            [general]
                            enableFluxRecipe = false
                            enableChunkLoading = true
                            
                            [blacklist]
                            blockBlacklistStrings = ["actuallyadditions:block_phantom_energyface"]
                            itemBlackListStrings = []
                            
                            [energy]
                            defaultLimit = 800000
                            basicCapacity = 2000000
                            basicTransfer = 20000
                            herculeanCapacity = 16000000
                            herculeanTransfer = 120000
                            gargantuanCapacity = 128000000
                            gargantuanTransfer = 720000""";
                    Files.writeString(fluxnetworks.toPath(), Content);
                } catch (IOException e){
                    ModPack.LOGGER.error("Error processing config file: {}", e.getMessage());
                }
            }
        }else {
            if (ModList.get().isLoaded("fluxnetworks")){
                File fluxnetworks = new File("defaultconfigs", "fluxnetworks-server.toml");
                if (!fluxnetworks.exists() && !fluxnetworks.createNewFile()){
                    ModPack.LOGGER.error(ModPack.ERROR_CREATEFILE);
                }
                try {
                    String Content = """
                            [networks]
                            maximumPerPlayer = 5
                            enableSuperAdmin = true
                            superAdminRequiredPermission = 1
                            
                            [general]
                            enableFluxRecipe = true
                            enableChunkLoading = true
                            
                            [blacklist]
                            blockBlacklistStrings = ["actuallyadditions:block_phantom_energyface"]
                            itemBlackListStrings = []
                            
                            [energy]
                            defaultLimit = 800000
                            basicCapacity = 2000000
                            basicTransfer = 20000
                            herculeanCapacity = 16000000
                            herculeanTransfer = 120000
                            gargantuanCapacity = 128000000
                            gargantuanTransfer = 720000""";
                    Files.writeString(fluxnetworks.toPath(), Content);
                } catch (IOException e){
                    ModPack.LOGGER.error("Error processing config file: {}", e.getMessage());
                }
            }
        }
    }
}
    /*    if (ModList.get().isLoaded("fluxnetworks")) {//if Mod is Loaded
            File defaultConfigDir = new File("defaultconfigs");
            File ConfigDir = new File("config");
            File sourceConfig = new File(ConfigDir, "fluxnetworks-server.toml");
            File targetConfig = new File(defaultConfigDir, "fluxnetworks-server.toml");
            try {
                if (!targetConfig.exists() && !targetConfig.createNewFile()) {
                    ModPack.LOGGER.error(ModPack.ERROR_CREATEFILE + "fluxnetworks-server.toml");
                    return;
                }
                String configContent = readFileContent(sourceConfig.toString());
                configContent = modifyEnableFluxRecipe(configContent);
                Files.writeString(targetConfig.toPath(), configContent, StandardOpenOption.TRUNCATE_EXISTING);
                ModPack.LOGGER.info("Succeed in creating fluxnetworks config");
            } catch (IOException e) {
                ModPack.LOGGER.error("Error processing config file: {}", e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    private String readFileContent(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        return String.join("\n", lines);
    }
    private String modifyEnableFluxRecipe(String originalContent) {
        return originalContent.replaceAll("(enableFluxRecipe\\s*=\\s*)(true)", "$1false");
    }*/
