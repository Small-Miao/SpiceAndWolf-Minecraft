package com.miaoluo.spiceandwolf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.miaoluo.spiceandwolf.item.*;
import com.miaoluo.spiceandwolf.item.food.*;
import com.miaoluo.spiceandwolf.effect.*;

public class Spiceandwolf implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spice_and_wolf");
    //Effect
    public static final FullStomach fullStomach = (FullStomach) new FullStomach().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
    //Main Item
    public static final DebugTool DebugTool = new DebugTool(new FabricItemSettings().rarity(Rarity.EPIC));
    //Food Item
    public static final WholeWheatBread wholeWheatBread = new WholeWheatBread(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0.8f).hunger(10).statusEffect(new StatusEffectInstance(fullStomach,270),1f).build()));
    public static final TornWholeWheatBread tornWholeWheatBread = new TornWholeWheatBread(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0.4f).hunger(5).build()));
    public static final WholeWheatDough wholeWheatDouge = new WholeWheatDough(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0f).hunger(1).build()));
    public static final CookedWholeWheatDouge coockedWholeWheatDouge = new CookedWholeWheatDouge(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0).hunger(6).build()));
    public static final OatFlour otaFlour = new OatFlour(new FabricItemSettings());
    //Item Group
    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
                new Identifier("spice_and_wolf", "main_item")).icon(() -> new ItemStack((DebugTool))).appendItems(stacks -> {
            stacks.add(new ItemStack(Spiceandwolf.DebugTool));
        }).build();
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.create(
                new Identifier("spice_and_wolf", "food_item")).icon(() -> new ItemStack((wholeWheatBread))).appendItems(stacks -> {
                    stacks.add(new ItemStack(Spiceandwolf.otaFlour));
                    stacks.add(new ItemStack(Spiceandwolf.wholeWheatDouge));
                    stacks.add(new ItemStack(Spiceandwolf.coockedWholeWheatDouge));
                    stacks.add(new ItemStack(Spiceandwolf.wholeWheatBread));
                    stacks.add(new ItemStack(Spiceandwolf.tornWholeWheatBread));
    }).build();
    @Override
    public void onInitialize() {
        LOGGER.info("mod Spice And Wolf On Initialize...");
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","debug_tool"),DebugTool);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","whole_wheat_bread"),wholeWheatBread);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","torn_whole_wheat_bread"), tornWholeWheatBread);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","whole_wheat_douge"),wholeWheatDouge);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","cooked_whole_wheat_douge"), coockedWholeWheatDouge);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","oat_flour"),otaFlour);
        Registry.register(Registry.STATUS_EFFECT,new Identifier("spice_and_wolf","full_stomach"),fullStomach);
    }
}
