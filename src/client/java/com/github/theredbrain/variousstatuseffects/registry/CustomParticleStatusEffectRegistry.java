package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.variousstatuseffects.effect.BleedingParticleSpawner;
import com.github.theredbrain.variousstatuseffects.effect.HitStunParticleSpawner;
import net.spell_engine.api.effect.CustomParticleStatusEffect;

public class CustomParticleStatusEffectRegistry {
	public static void init() {
		CustomParticleStatusEffect.register(StatusEffectsRegistry.BLEEDING, new BleedingParticleSpawner());
		CustomParticleStatusEffect.register(StatusEffectsRegistry.HIT_STUN, new HitStunParticleSpawner());
	}
}
