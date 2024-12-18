package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class NeutralStatusEffect extends StatusEffect {

	public NeutralStatusEffect(int color) {
		super(StatusEffectCategory.NEUTRAL, color);
	}

	public NeutralStatusEffect() {
		this(3381504);
	}
}
