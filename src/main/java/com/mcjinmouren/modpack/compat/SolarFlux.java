package com.mcjinmouren.modpack.compat;

import com.mcjinmouren.modpack.ModPack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SolarFlux {

    @SubscribeEvent
    public void onCommonSetup(FMLLoadCompleteEvent event) {
        if (ModList.get().isLoaded("botania")) {
            if (ModList.get().isLoaded("solarflux")) {
                File ConfigDir = new File("config", "solarflux");
                File CustomSolarPanel = new File(ConfigDir, "custom_panels.js");
                try {
                    if (!CustomSolarPanel.exists() && !CustomSolarPanel.createNewFile()) {
                        ModPack.LOGGER.error(ModPack.ERROR_CREATEFILE + "custom_panels.js");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    String configContent = """
                            function init() {
                                panel()
                                    .name("botania.manasteel")
                                    .height(6 / 16.0)
                                    .generation("4096")
                                    .capacity("4915200")
                                    .transfer("3072")
                                    .buildAndRegister()
                                    .langBuilder()
                                    .put("en_us", "Manasteel Solar Panel")
                                    .put("zh_cn", "魔力太阳能板")
                                    .build();
                                panel()
                                    .name("botania.elementium")
                                    .height(6 / 16.0)
                                    .generation("8192")
                                    .capacity("9830400")
                                    .transfer("6144")
                                    .buildAndRegister()
                                    .langBuilder()
                                    .put("en_us", "Elementium Solar Panel")
                                    .put("zh_cn", "精灵太阳能板")
                                    .build();
                                panel()
                                    .name("botania.gaia")
                                    .height(6 / 16.0)
                                    .generation("32768")
                                    .capacity("39321600")
                                    .transfer("40000")
                                    .buildAndRegister()
                                    .langBuilder()
                                    .put("en_us", "Gaia Solar Panel")
                                    .put("zh_cn", "盖亚太阳能板")
                                    .build();
                                panel()
                                    .name("botania.terrasteel")
                                    .height(6 / 16.0)
                                    .generation("16384")
                                    .capacity("19660800")
                                    .transfer("18000")
                                    .buildAndRegister()
                                    .langBuilder()
                                    .put("en_us", "Terrasteel Solar Panel")
                                    .put("zh_cn", "泰拉太阳能板")
                                    .build();
                            }
                            """;
                    Files.writeString(CustomSolarPanel.toPath(), configContent);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ModPack.LOGGER.info("Succeed in creating custom solar panels config!");
            }
        }
    }
}

