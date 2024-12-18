package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.entity.DuckLivingEntityMixin;
import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;

public class BleedingStatusEffect extends HarmfulStatusEffect {
	public BleedingStatusEffect() {
		super(VariousStatusEffects.SERVER_CONFIG.bleedingSection.effect_color.toInt());
	}

	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		super.applyUpdateEffect(entity, amplifier);
		if (!entity.getEntityWorld().isClient) {
			ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
			boolean isMoving = ((DuckLivingEntityMixin) entity).overhauleddamage$isMoving() && serverConfig.bleedingSection.moving_doubles_damage.get();
			float bleedingDamage = Math.max(1.0f, (float) (entity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH) * serverConfig.bleedingSection.max_health_multiplier.get())) * (isMoving ? 2 : 1);
			entity.damage(((DuckDamageSourcesMixin) entity.getDamageSources()).variousstatuseffects$bleeding(), bleedingDamage);
		}
	}

	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration % VariousStatusEffects.SERVER_CONFIG.bleedingSection.tick_update_threshold.get() == 1;
	}
}
