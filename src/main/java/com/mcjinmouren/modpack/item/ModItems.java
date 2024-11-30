package com.mcjinmouren.modpack.item;

import com.mcjinmouren.modpack.ModPack;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModPack.MOD_ID);

    public static final RegistryObject<Item> SWAP_CORE = ITEMS.register(
            "swap_core", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UPGRADE_CORE = ITEMS.register(
            "upgrade_core", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CANT_CRAFTING = ITEMS.register(
            "cant_crafting", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CAST_IRON = ITEMS.register(
            "cast_iron", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CAST_IRON_PLATE = ITEMS.register(
            "cast_iron_plate", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
