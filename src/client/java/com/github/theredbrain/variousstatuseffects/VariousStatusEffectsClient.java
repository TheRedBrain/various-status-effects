package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.registry.CustomParticleStatusEffectRegistry;
import com.github.theredbrain.variousstatuseffects.registry.ParticleFactoriesRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class VariousStatusEffectsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleFactoriesRegistry.registerParticleFactories();
		if (VariousStatusEffects.isSpellEngineLoaded) {
			CustomParticleStatusEffectRegistry.init();
		}
	}
}