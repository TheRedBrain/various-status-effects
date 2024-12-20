package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import org.jetbrains.annotations.Nullable;

public class ShockedInstantStatusEffect extends InstantStatusEffect {
	public ShockedInstantStatusEffect() {
		super(StatusEffectCategory.HARMFUL, VariousStatusEffects.SERVER_CONFIG.shockedInstantSection.effect_color.toInt());
	}

	public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
		entity.damage(((DuckDamageSourcesMixin) entity.getDamageSources()).variousstatuseffects$shocked(), VariousStatusEffects.SERVER_CONFIG.shockedInstantSection.damage.get());
		return super.applyUpdateEffect(entity, amplifier);
	}

	@Override
	public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
		target.damage(((DuckDamageSourcesMixin) target.getDamageSources()).variousstatuseffects$shocked(), VariousStatusEffects.SERVER_CONFIG.shockedInstantSection.damage.get());
	}

}
