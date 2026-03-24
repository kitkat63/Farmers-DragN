package com.farmersdragn.farmersdragn;

import com.farmersdragn.farmersdragn.compat.CompatModules;
import com.farmersdragn.farmersdragn.compat.FishDropNormalizer;
import com.farmersdragn.farmersdragn.registry.ModCreativeTabs;
import com.farmersdragn.farmersdragn.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FarmersDragn.MOD_ID)
public class FarmersDragn {
    public static final String MOD_ID = "farmersdragn";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String CREATIVE_LOGO_URL = "https://raw.githubusercontent.com/your-org/farmersdragn-assets/main/logo/farmersdragn_tab_logo.png";
    public static final String MOD_LISTING_LOGO_URL = "https://raw.githubusercontent.com/your-org/farmersdragn-assets/main/logo/farmersdragn_mod_logo.png";

    public FarmersDragn() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreativeTabItems);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new FishDropNormalizer());
    }


    private void addCreativeTabItems(final BuildCreativeModeTabContentsEvent event) {
        ModItems.addCreativeTabItems(event);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Branding URLs -> creative tab: {} | mod listing: {}", CREATIVE_LOGO_URL, MOD_LISTING_LOGO_URL);
            CompatModules.ALL.forEach(module -> {
            if (ModList.get().isLoaded(module.modId())) {
                LOGGER.info("{} compat enabled.", module.displayName());
            } else {
                LOGGER.info("{} compat not loaded; skipping optional hooks.", module.displayName());
            }
            });
        });
    }
}
