package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class AuraStatusEffect extends StatusEffect {

	private final boolean applyToSelf;
	private final boolean requiresMana;
	private final boolean propagatesAmplifier;
	private final int rangeRadius;
	private final long applicationInterval;
	private final RegistryEntry<StatusEffect> appliedStatusEffect;
	private final int appliedStatusEffectDuration;
	private final int appliedStatusEffectAmplifier;
	private final boolean appliedStatusEffectAmbient;
	private final boolean appliedStatusEffectShowParticles;
	private final boolean appliedStatusEffectShowIcon;

	public AuraStatusEffect(StatusEffectCategory category, int color, boolean applyToSelf, boolean requiresMana, boolean propagatesAmplifier, int rangeRadius, long applicationInterval, RegistryEntry<StatusEffect> appliedStatusEffect, int appliedStatusEffectDuration, int appliedStatusEffectAmplifier, boolean appliedStatusEffectAmbient, boolean appliedStatusEffectShowParticles, boolean appliedStatusEffectShowIcon) {
		super(category, color);
		this.applyToSelf = applyToSelf;
		this.requiresMana = requiresMana;
		this.propagatesAmplifier = propagatesAmplifier;
		this.rangeRadius = rangeRadius;
		this.applicationInterval = applicationInterval;
		this.appliedStatusEffect = appliedStatusEffect;
		this.appliedStatusEffectDuration = appliedStatusEffectDuration;
		this.appliedStatusEffectAmplifier = appliedStatusEffectAmplifier;
		this.appliedStatusEffectAmbient = appliedStatusEffectAmbient;
		this.appliedStatusEffectShowParticles = appliedStatusEffectShowParticles;
		this.appliedStatusEffectShowIcon = appliedStatusEffectShowIcon;
	}

	@Override
	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		World world = entity.getWorld();
		if (world.getTime() % this.applicationInterval == 0L && !world.isClient) {
			if (this.requiresMana && VariousStatusEffects.getCurrentMana(entity) <= 0) {
				return false;
			}
			BlockPos entityBlockPos = entity.getBlockPos();
			Box box = new Box(entityBlockPos).expand(this.rangeRadius);
			List<LivingEntity> list = world.getNonSpectatingEntities(LivingEntity.class, box);
			Iterator var11 = list.iterator();

			LivingEntity livingEntity;
			while (var11.hasNext()) {
				livingEntity = (LivingEntity) var11.next();
				if (livingEntity == entity && !this.applyToSelf) {
					continue;
				}
				livingEntity.addStatusEffect(new StatusEffectInstance(this.appliedStatusEffect, this.appliedStatusEffectDuration, this.propagatesAmplifier ? amplifier : this.appliedStatusEffectAmplifier, this.appliedStatusEffectAmbient, this.appliedStatusEffectShowParticles, this.appliedStatusEffectShowIcon));
			}
		}
		return super.applyUpdateEffect(entity, amplifier);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
