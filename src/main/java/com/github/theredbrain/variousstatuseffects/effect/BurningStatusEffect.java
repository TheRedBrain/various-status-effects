package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import net.minecraft.entity.LivingEntity;

public class BurningStatusEffect extends HarmfulStatusEffect {
	public BurningStatusEffect() {
		super(VariousStatusEffects.SERVER_CONFIG.burningSection.effect_color.toInt());
	}

	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.damage(((DuckDamageSourcesMixin) entity.getDamageSources()).variousstatuseffects$burning(), VariousStatusEffects.SERVER_CONFIG.burningSection.damage_per_tick.get());
		return super.applyUpdateEffect(entity, amplifier);
	}

	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % VariousStatusEffects.SERVER_CONFIG.burningSection.tick_update_threshold.get() == 1;
	}
}
