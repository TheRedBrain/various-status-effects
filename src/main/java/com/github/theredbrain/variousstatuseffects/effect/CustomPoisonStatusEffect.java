package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import net.minecraft.entity.LivingEntity;

public class CustomPoisonStatusEffect extends HarmfulStatusEffect {
	public CustomPoisonStatusEffect() {
		super(VariousStatusEffects.SERVER_CONFIG.poisonSection.effect_color.toInt());
	}

	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		float poisonDamage = amplifier + 1;
		entity.damage(((DuckDamageSourcesMixin) entity.getDamageSources()).variousstatuseffects$poison(), poisonDamage * VariousStatusEffects.SERVER_CONFIG.poisonSection.amplifier_multiplier.get());
		return super.applyUpdateEffect(entity, amplifier);
	}

	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % VariousStatusEffects.SERVER_CONFIG.poisonSection.tick_update_threshold.get() == 1;
	}
}
