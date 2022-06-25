package com.miaoluo.spiceandwolf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.ILoggerFactory;
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
    public static final Barleybread barleyBread = new Barleybread(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0.8f).hunger(10).statusEffect(new StatusEffectInstance(fullStomach,270),1f).build()));
    public static final TornBarleyBread tornBarleyBread = new TornBarleyBread(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0.4f).hunger(5).build()));
    public static final BarleyDough barleyDouge = new BarleyDough(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0f).hunger(1).build()));
    public static final CookedBarleyDouge cookedBarleyDouge = new CookedBarleyDouge(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0).hunger(6).build()));
    //Item Group
    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
                new Identifier("spice_and_wolf", "main_item")).icon(() -> new ItemStack((DebugTool))).appendItems(stacks -> {
            stacks.add(new ItemStack(Spiceandwolf.DebugTool));
        }).build();
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.create(
                new Identifier("spice_and_wolf", "food_item")).icon(() -> new ItemStack((barleyBread))).appendItems(stacks -> {
                    stacks.add(new ItemStack(Spiceandwolf.barleyDouge));
                    stacks.add(new ItemStack(Spiceandwolf.cookedBarleyDouge));
                    stacks.add(new ItemStack(Spiceandwolf.barleyBread));
                    stacks.add(new ItemStack(Spiceandwolf.tornBarleyBread));
    }).build();
    @Override
    public void onInitialize() {
        LOGGER.info("mod Spice And Wolf On Initialize...");
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","debug_tool"),DebugTool);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","barley_bread"),barleyBread);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","torn_barley_bread"),tornBarleyBread);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","barley_douge"),barleyDouge);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","cooked_barley_douge"),cookedBarleyDouge);
        Registry.register(Registry.STATUS_EFFECT,new Identifier("spice_and_wolf","full_stomach"),fullStomach);
    }
}
