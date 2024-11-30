package com.mcjinmouren.modpack;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import javax.annotation.Nonnull;

public class ModPackConfig {

    public static final ForgeConfigSpec COMMON_SPEC;
    private static final Common COMMON;

    public static String EnableFluxNetworksRecipe_key = ModPack.MOD_ID + ".config.enableFluxNetworksRecipe";
    public static String EnableFastLinkForChina_key = ModPack.MOD_ID + ".config.enableFastLinkForChina";
    public static boolean enableFluxNetworksRecipe;
    public static boolean enableFastLinkForChina;

    static {
        ForgeConfigSpec.Builder builder;
        builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }

    static void reload(@Nonnull ModConfigEvent event) {
        final IConfigSpec<?> spec = event.getConfig().getSpec();
        if (spec == COMMON_SPEC){
            COMMON.load();
            ModPack.LOGGER.info("Common Config Loaded");
        }
    }

    private static class Common {
        private final ForgeConfigSpec.BooleanValue mEnableFluxNetworksRecipe, mEnableFastLinkForChina;

        private Common(@Nonnull ForgeConfigSpec.Builder builder) {
            builder.push("General");
            mEnableFluxNetworksRecipe = builder
                    .comment("Enabling this option will allow the use of the original Flux Dust crafting recipe from Fluxnetworks.")
                    .translation(EnableFluxNetworksRecipe_key)
                    .define("enableFluxNetworksRecipe", false);
            mEnableFastLinkForChina = builder
                    .comment("Use download links that are faster for Mainland China.")
                    .translation(EnableFastLinkForChina_key)
                    .define("enableFastLinkForChina", true);
            builder.pop();
        }

        private void load() {
            enableFluxNetworksRecipe = mEnableFluxNetworksRecipe.get();
            enableFastLinkForChina = mEnableFastLinkForChina.get();
        }
    }

}
