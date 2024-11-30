package com.mcjinmouren.modpack;

import com.mcjinmouren.modpack.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTab {

    public static final String MODPACK_TAB = "modpack.creativetab.mod_tab";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModPack.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register(
            "mod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SWAP_CORE.get())) //CreativeTab ICON
                    .title(Component.translatable(MODPACK_TAB))
                    .displayItems((pParameters, pOutput) -> {
                        //ITEMS
                        pOutput.accept(ModItems.SWAP_CORE.get());
                        pOutput.accept(ModItems.UPGRADE_CORE.get());
                        pOutput.accept(ModItems.CAST_IRON.get());
                        pOutput.accept(ModItems.CAST_IRON_PLATE.get());
                    })      //Add Items
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
