package com.farmersdragn.farmersdragn.registry;

import com.farmersdragn.farmersdragn.FarmersDragn;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import java.util.List;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmersDragn.MOD_ID);

    public static final RegistryObject<Item> FARM_CHEESE_CUT = ITEMS.register("farm_cheese_cut", ModItems::createCheeseCutItem);
    public static final RegistryObject<Item> GOAT_CHEESE_CUT = ITEMS.register("goat_cheese_cut", ModItems::createCheeseCutItem);
    public static final RegistryObject<Item> LLAMA_CHEESE_CUT = ITEMS.register("llama_cheese_cut", ModItems::createCheeseCutItem);
    public static final RegistryObject<Item> SHEEP_CHEESE_CUT = ITEMS.register("sheep_cheese_cut", ModItems::createCheeseCutItem);
    public static final RegistryObject<Item> GOAT_CHEESE_TOAST = ITEMS.register("goat_cheese_toast", () -> createFoodItem(5, 0.6F));
    public static final RegistryObject<Item> HONEY_SWEET_CHEESE = ITEMS.register("honey_sweet_cheese", () -> createFoodItem(4, 0.5F));
    public static final RegistryObject<Item> EGG_TOAST = ITEMS.register("egg_toast", () -> createFoodItem(6, 0.6F));
    public static final RegistryObject<Item> SWEET_JERKY = ITEMS.register("sweet_jerky", () -> createFoodItem(5, 0.5F));
    public static final RegistryObject<Item> FISH_SANDWICH = ITEMS.register("fish_sandwich", () -> createFoodItem(7, 0.7F));
    public static final RegistryObject<Item> ROE_RICE_BOWL = ITEMS.register("roe_rice_bowl", () -> createFoodItem(8, 0.8F));
    public static final RegistryObject<Item> FISHERMANS_FEAST = ITEMS.register("fishermans_feast", () -> createFoodItem(10, 0.9F));
    public static final RegistryObject<Item> CAZUELA_DE_LLAMA = ITEMS.register("cazuela_de_llama", () -> createBowlMealItem(10, 0.75F));
    public static final RegistryObject<Item> SWEDISH_MEATBALLS = ITEMS.register("swedish_meatballs", () -> createBowlMealItem(12, 0.9F));
    public static final RegistryObject<Item> CHEVON_STEW_CLASSIC = ITEMS.register("chevon_stew_classic", () -> createBowlMealItem(11, 0.85F));
    public static final RegistryObject<Item> FARIKAL_STEW = ITEMS.register("farikal_stew", () -> createBowlMealItem(9, 0.7F));
    public static final RegistryObject<Item> BOSINTANG = ITEMS.register("bosintang", () -> createBowlMealItemWithEffect(10, 0.75F, MobEffects.HUNGER, 200, 0, 0.2F));
    public static final RegistryObject<Item> SWEET_BERRY_WOLF = ITEMS.register("sweet_berry_wolf", () -> createBowlMealItem(8, 0.7F));
    public static final RegistryObject<Item> KITTY_FRITTERS = ITEMS.register("kitty_fritters", () -> createFoodItemWithEffect(7, 0.6F, MobEffects.CONFUSION, 160, 0, 0.2F));
    public static final RegistryObject<Item> DOG_FOOD = ITEMS.register("dog_food", () -> createBowlMealItemWithEffect(4, 0.35F, MobEffects.POISON, 120, 0, 1.0F));
    public static final RegistryObject<Item> CAT_FOOD = ITEMS.register("cat_food", () -> createBowlMealItemWithEffect(4, 0.35F, MobEffects.POISON, 120, 0, 1.0F));
    public static final RegistryObject<Item> TROPICAL_FISH_BOWL = ITEMS.register("tropical_fish_bowl", () -> createBowlMealItem(8, 0.7F));
    public static final RegistryObject<Item> TROPICAL_ROE_BOWL = ITEMS.register("tropical_roe_bowl", () -> createBowlMealItem(9, 0.8F));
    public static final RegistryObject<Item> CARIBOU_HARVEST_HASH = ITEMS.register("caribou_harvest_hash", () -> createBowlMealItem(12, 0.8F));
    public static final RegistryObject<Item> KOFTA = ITEMS.register("kofta", () -> createBowlMealItem(12, 0.75F));
    public static final RegistryObject<Item> CREAMY_MUSHROOM_BRAISED_LOIN = ITEMS.register("creamy_mushroom_braised_loin", () -> createBowlMealItem(10, 0.8F));
    public static final RegistryObject<Item> RABBIT_BACKSTRAP = ITEMS.register("rabbit_backstrap", () -> createFoodItem(1, 0.25F));
    public static final RegistryObject<Item> COOKED_RABBIT_BACKSTRAP = ITEMS.register("cooked_rabbit_backstrap", () -> createFoodItem(4, 0.7F));
    public static final RegistryObject<Item> FARMERS_DRAGN_MINI = ITEMS.register("farmers_dragn_mini", () -> new Item(new Item.Properties()));

    private ModItems() {
    }


    public static void addCreativeTabItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.FOOD_AND_DRINKS) {
            getFoodItems().forEach(event::accept);
        }
    }

    public static List<Item> getFoodItems() {
        return List.of(
                FARM_CHEESE_CUT.get(),
                GOAT_CHEESE_CUT.get(),
                LLAMA_CHEESE_CUT.get(),
                SHEEP_CHEESE_CUT.get(),
                GOAT_CHEESE_TOAST.get(),
                HONEY_SWEET_CHEESE.get(),
                EGG_TOAST.get(),
                SWEET_JERKY.get(),
                FISH_SANDWICH.get(),
                ROE_RICE_BOWL.get(),
                FISHERMANS_FEAST.get(),
                CAZUELA_DE_LLAMA.get(),
                SWEDISH_MEATBALLS.get(),
                CHEVON_STEW_CLASSIC.get(),
                FARIKAL_STEW.get(),
                BOSINTANG.get(),
                SWEET_BERRY_WOLF.get(),
                KITTY_FRITTERS.get(),
                DOG_FOOD.get(),
                CAT_FOOD.get(),
                TROPICAL_FISH_BOWL.get(),
                TROPICAL_ROE_BOWL.get(),
                CARIBOU_HARVEST_HASH.get(),
                KOFTA.get(),
                CREAMY_MUSHROOM_BRAISED_LOIN.get(),
                RABBIT_BACKSTRAP.get(),
                COOKED_RABBIT_BACKSTRAP.get());
    }

    public static List<Item> getAllItems() {
        return List.of(
                FARM_CHEESE_CUT.get(),
                GOAT_CHEESE_CUT.get(),
                LLAMA_CHEESE_CUT.get(),
                SHEEP_CHEESE_CUT.get(),
                GOAT_CHEESE_TOAST.get(),
                HONEY_SWEET_CHEESE.get(),
                EGG_TOAST.get(),
                SWEET_JERKY.get(),
                FISH_SANDWICH.get(),
                ROE_RICE_BOWL.get(),
                FISHERMANS_FEAST.get(),
                CAZUELA_DE_LLAMA.get(),
                SWEDISH_MEATBALLS.get(),
                CHEVON_STEW_CLASSIC.get(),
                FARIKAL_STEW.get(),
                BOSINTANG.get(),
                SWEET_BERRY_WOLF.get(),
                KITTY_FRITTERS.get(),
                DOG_FOOD.get(),
                CAT_FOOD.get(),
                TROPICAL_FISH_BOWL.get(),
                TROPICAL_ROE_BOWL.get(),
                CARIBOU_HARVEST_HASH.get(),
                KOFTA.get(),
                CREAMY_MUSHROOM_BRAISED_LOIN.get(),
                RABBIT_BACKSTRAP.get(),
                COOKED_RABBIT_BACKSTRAP.get());
    }

    private static Item createCheeseCutItem() {
        return createFoodItem(2, 0.3F);
    }

    private static Item createFoodItem(int nutrition, float saturation) {
        return new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation)
                .build()));
    }

    private static Item createBowlMealItem(int nutrition, float saturation) {
        return new Item(new Item.Properties()
                .stacksTo(16)
                .craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    private static Item createFoodItemWithEffect(int nutrition, float saturation, MobEffect effect, int duration, int amplifier, float probability) {
        return new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation)
                .effect(() -> new MobEffectInstance(effect, duration, amplifier), probability)
                .build()));
    }

    private static Item createBowlMealItemWithEffect(int nutrition, float saturation, MobEffect effect, int duration, int amplifier, float probability) {
        return new Item(new Item.Properties()
                .stacksTo(16)
                .craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .effect(() -> new MobEffectInstance(effect, duration, amplifier), probability)
                        .build()));
    }
}
