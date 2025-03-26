package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class InstantStaminaLossStatusEffect extends InstantStatusEffect {
	public InstantStaminaLossStatusEffect() {
		super(StatusEffectCategory.HARMFUL, VariousStatusEffects.SERVER_CONFIG.instantStaminaLossSection.effect_color.toInt());
	}

	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		VariousStatusEffects.addStamina(entity, - VariousStatusEffects.SERVER_CONFIG.instantStaminaLossSection.loss_per_level.get() * (amplifier + 1));
		return true;
	}

	@Override
	public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
		VariousStatusEffects.addStamina(target, - VariousStatusEffects.SERVER_CONFIG.instantStaminaLossSection.loss_per_level.get() * (amplifier + 1));
	}

}
