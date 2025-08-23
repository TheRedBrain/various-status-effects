package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;

public class RemoveEffectsStatusEffect extends StatusEffect {
	private final TagKey<StatusEffect> removedEffects;

	public RemoveEffectsStatusEffect(TagKey<StatusEffect> removedEffects, StatusEffectCategory category, int color) {
		super(category, color);
		this.removedEffects = removedEffects;
	}

	@Override
	public void onApplied(LivingEntity entity, int amplifier) {
		this.removeEffects(entity);
	}

	private void removeEffects(LivingEntity livingEntity) {
		for (StatusEffectInstance currentEffect : livingEntity.getStatusEffects().stream().toList()) {
			RegistryEntry<StatusEffect> statusEffectRegistryEntry = currentEffect.getEffectType();
			if (statusEffectRegistryEntry.value() instanceof RemoveEffectsStatusEffect || statusEffectRegistryEntry.isIn(this.removedEffects)) {
				livingEntity.removeStatusEffect(statusEffectRegistryEntry);
			}
		}
	}
}
