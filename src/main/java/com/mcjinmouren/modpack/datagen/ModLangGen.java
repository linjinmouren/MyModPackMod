package com.mcjinmouren.modpack.datagen;

import com.mcjinmouren.modpack.ModCreativeModeTab;
import com.mcjinmouren.modpack.ModPack;
import com.mcjinmouren.modpack.ModPackConfig;
import com.mcjinmouren.modpack.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangGen extends LanguageProvider {

    public ModLangGen(PackOutput output, String locale) {
        super(output, ModPack.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //Register Mod Items and String Name(en_us)
        add(ModItems.SWAP_CORE.get(), "Swap Core");
        add(ModItems.UPGRADE_CORE.get(), "Upgrade Core");
        add(ModItems.CANT_CRAFTING.get(), "Can't Crafting");
        add(ModItems.CAST_IRON.get(), "Cast Iron Ingot");
        add(ModItems.CAST_IRON_PLATE.get(), "Cast Iron Plate");
        add(ModCreativeModeTab.MODPACK_TAB, "Modpack Items");
        //    add(ModPack.ERROR_MKDIR, "Unable to create folder");
        add(ModPack.ERROR_CREATEFILE, "Failed to create file");
        add(ModPackConfig.EnableFluxNetworksRecipe_key, "Enable Flux Networks Recipe");
    }

}
