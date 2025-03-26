package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.effect.BleedingParticleSpawner;
import com.github.theredbrain.variousstatuseffects.effect.HitStunParticleSpawner;
import com.github.theredbrain.variousstatuseffects.registry.ParticleFactoriesRegistry;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.spell_engine.api.effect.CustomParticleStatusEffect;

@Environment(EnvType.CLIENT)
public class VariousStatusEffectsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleFactoriesRegistry.registerParticleFactories();
		CustomParticleStatusEffect.register(StatusEffectsRegistry.BLEEDING, new BleedingParticleSpawner());
		CustomParticleStatusEffect.register(StatusEffectsRegistry.HIT_STUN, new HitStunParticleSpawner());
	}
}