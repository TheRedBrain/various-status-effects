package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.effect.BleedingParticleSpawner;
import com.github.theredbrain.variousstatuseffects.registry.ParticleFactoriesRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.spell_engine.api.effect.CustomParticleStatusEffect;

@Environment(EnvType.CLIENT)
public class VariousStatusEffectsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleFactoriesRegistry.registerParticleFactories();
		CustomParticleStatusEffect.register(VariousStatusEffects.BLEEDING, new BleedingParticleSpawner());
	}
}