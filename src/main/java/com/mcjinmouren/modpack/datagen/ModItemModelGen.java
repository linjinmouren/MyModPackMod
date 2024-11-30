package com.mcjinmouren.modpack.datagen;

import com.mcjinmouren.modpack.ModPack;
import com.mcjinmouren.modpack.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelGen extends ItemModelProvider {

    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public ModItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ModPack.MOD_ID, existingFileHelper);
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(ItemName(item), GENERATED).texture("layer0", texture);
    }

    public String ItemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(ModPack.MOD_ID, "item/" + path);
    }


    @Override
    protected void registerModels() {    //Register Mod Items Models
        itemGeneratedModel(ModItems.SWAP_CORE.get(), resourceItem(ItemName(ModItems.SWAP_CORE.get())));
        itemGeneratedModel(ModItems.UPGRADE_CORE.get(), resourceItem(ItemName(ModItems.UPGRADE_CORE.get())));
        itemGeneratedModel(ModItems.CANT_CRAFTING.get(), resourceItem(ItemName(ModItems.CANT_CRAFTING.get())));
        itemGeneratedModel(ModItems.CAST_IRON.get(), resourceItem(ItemName(ModItems.CAST_IRON.get())));
        itemGeneratedModel(ModItems.CAST_IRON_PLATE.get(), resourceItem(ItemName(ModItems.CAST_IRON_PLATE.get())));
    }


}
