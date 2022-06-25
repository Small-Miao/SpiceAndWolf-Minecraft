package com.miaoluo.spiceandwolf;

import com.miaoluo.spiceandwolf.item.DebugTool;
import com.miaoluo.spiceandwolf.item.food.Barleybread;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.miaoluo.spiceandwolf.item.*;

public class Spiceandwolf implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spice_and_wolf");
    public static final DebugTool DebugTool = new DebugTool(new FabricItemSettings().group(Spiceandwolf.MAIN_GROUP).rarity(Rarity.EPIC));
    public static final Barleybread barleyBread = new Barleybread(new FabricItemSettings().food(new FoodComponent.Builder().saturationModifier(0.6f).hunger(7).build()));
    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
            new Identifier("spice_and_wolf","main_item")).icon(()->new ItemStack((DebugTool))).appendItems(stacks->{
        stacks.add(new ItemStack(Spiceandwolf.DebugTool));
    }).build();
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.create(
            new Identifier("spice_and_wolf","food_item")).icon(()->new ItemStack((DebugTool))).appendItems(stacks->{
        stacks.add(new ItemStack(Spiceandwolf.barleyBread));
    }).build();
    @Override
    public void onInitialize() {
        LOGGER.info("mod Spice And Wolf On Initialize...");
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","debug_tool"),DebugTool);
        Registry.register(Registry.ITEM,new Identifier("spice_and_wolf","barley_bread"),barleyBread);
    }
}
