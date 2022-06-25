package com.miaoluo.spiceandwolf.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FullStomach extends StatusEffect{
    public FullStomach() {
        super(
                StatusEffectCategory.NEUTRAL, // whether beneficial or harmful for entities
                0x98D982); // color in RGB
    }



}
