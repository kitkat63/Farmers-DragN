package com.farmersdragn.farmersdragn.registry;

import com.farmersdragn.farmersdragn.FarmersDragn;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmersDragn.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = CREATIVE_MODE_TABS.register("main", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.farmersdragn.main"))
                    .icon(() -> new ItemStack(ModItems.FARMERS_DRAGN_MINI.get()))
                    .displayItems((parameters, output) -> ModItems.getAllItems().forEach(output::accept))
                    .build());

    private ModCreativeTabs() {
    }
}
