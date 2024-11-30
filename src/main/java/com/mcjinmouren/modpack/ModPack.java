package com.mcjinmouren.modpack;

import com.mcjinmouren.modpack.compat.FluxNetworks;
import com.mcjinmouren.modpack.compat.SolarFlux;
import com.mcjinmouren.modpack.item.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModPack.MOD_ID)
public class ModPack {

    public static final String MOD_ID = "modpack";  //Mod ID String
    public static final String ERROR_CREATEFILE = "modpack.error_createfile";
    // public static final String ERROR_MKDIR = "modpack.error_mkdir";
    public static final Logger LOGGER = LogManager.getLogger();

    public ModPack() {
        LOGGER.info("Loading ModPack,Please wait!");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModPackConfig.COMMON_SPEC);
        ModItems.register(modEventBus);                 //Register Mod Items
        ModCreativeModeTab.register(modEventBus);       //Register Mod Creative Tab
        modEventBus.register(new FluxNetworks());       //Register FluxNetworks Config Writer
        modEventBus.register(new SolarFlux());          //Register Custom Solar Panels
        modEventBus.register(new ModDownloader());
        modEventBus.addListener(ModPackConfig::reload);
    }
}
