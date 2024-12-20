package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BeneficialStatusEffect extends StatusEffect {

	public BeneficialStatusEffect(int color) {
		super(StatusEffectCategory.BENEFICIAL, color);
	}

	public BeneficialStatusEffect() {
		this(3381504);
	}
}
