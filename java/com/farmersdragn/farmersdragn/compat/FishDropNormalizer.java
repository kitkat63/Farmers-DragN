package com.farmersdragn.farmersdragn.compat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class FishDropNormalizer {
    private static final ResourceLocation DRAGN_SALMON = ResourceLocation.tryParse("dragnlivestock:salmon");
    private static final ResourceLocation DRAGN_COD = ResourceLocation.tryParse("dragnlivestock:cod");
    private static final ResourceLocation DRAGN_TROPICAL_FISH = ResourceLocation.tryParse("dragnpets:o_tropical_fish");

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        if (!(event.getSource().getEntity() instanceof Player)) {
            return;
        }

        ResourceLocation entityId = BuiltInRegistries.ENTITY_TYPE.getKey(event.getEntity().getType());
        if (DRAGN_SALMON.equals(entityId)) {
            replaceDropsWithWholeFish(event, Items.SALMON);
        } else if (DRAGN_COD.equals(entityId)) {
            replaceDropsWithWholeFish(event, Items.COD);
        } else if (DRAGN_TROPICAL_FISH.equals(entityId)) {
            replaceDropsWithWholeFish(event, Items.TROPICAL_FISH);
        }
    }

    private static void replaceDropsWithWholeFish(LivingDropsEvent event, net.minecraft.world.item.Item fishItem) {
        event.getDrops().clear();
        event.getDrops().add(new ItemEntity(
                event.getEntity().level(),
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ(),
                new ItemStack(fishItem)
        ));
    }
}
