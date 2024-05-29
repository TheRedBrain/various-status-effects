package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.manaattributes.entity.ManaUsingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class AuraStatusEffect extends StatusEffect {

    private final boolean applyToSelf;
    private final boolean requiresMana;
    private final StatusEffect appliedStatusEffect;
    private final int appliedStatusEffectDuration;
    private final int appliedStatusEffectAmplifier;
    private final boolean appliedStatusEffectAmbient;
    private final boolean appliedStatusEffectShowParticles;
    private final boolean appliedStatusEffectShowIcon;

    public AuraStatusEffect(boolean applyToSelf, boolean requiresMana, StatusEffect appliedStatusEffect, int appliedStatusEffectDuration, int appliedStatusEffectAmplifier, boolean appliedStatusEffectAmbient, boolean appliedStatusEffectShowParticles, boolean appliedStatusEffectShowIcon) {
        super(StatusEffectCategory.BENEFICIAL, 3381504); // TODO better colour
        this.applyToSelf = applyToSelf;
        this.requiresMana = requiresMana;
        this.appliedStatusEffect = appliedStatusEffect;
        this.appliedStatusEffectDuration = appliedStatusEffectDuration;
        this.appliedStatusEffectAmplifier = appliedStatusEffectAmplifier;
        this.appliedStatusEffectAmbient = appliedStatusEffectAmbient;
        this.appliedStatusEffectShowParticles = appliedStatusEffectShowParticles;
        this.appliedStatusEffectShowIcon = appliedStatusEffectShowIcon;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (this.requiresMana && ((ManaUsingEntity)entity).manaattributes$getMana() <= 0) {
            entity.removeStatusEffect(this);
        }
        if (world.getTime() % 80L == 0L && !world.isClient) {
            BlockPos entityBlockPos = entity.getBlockPos();
            Box box = new Box(entityBlockPos).expand(10);
            List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, box);
            Iterator var11 = list.iterator();

            LivingEntity livingEntity;
            while(var11.hasNext()) {
                livingEntity = (LivingEntity)var11.next();
                if (livingEntity == entity && !this.applyToSelf) {
                    continue;
                }
                livingEntity.addStatusEffect(new StatusEffectInstance(this.appliedStatusEffect, this.appliedStatusEffectDuration, this.appliedStatusEffectAmplifier, this.appliedStatusEffectAmbient, this.appliedStatusEffectShowParticles, this.appliedStatusEffectShowIcon));
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
