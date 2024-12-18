package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class HarmfulStatusEffect extends StatusEffect {

	public HarmfulStatusEffect(int color) {
		super(StatusEffectCategory.HARMFUL, color);
	}

	public HarmfulStatusEffect() {
		this(3381504);
	}
}
