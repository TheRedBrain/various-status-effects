package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.DamageParticle;
import net.minecraft.client.particle.RainSplashParticle;

public class ParticleFactoriesRegistry {
	public static void registerParticleFactories() {
		ParticleFactoryRegistry.getInstance().register(VariousStatusEffects.BLOOD_DROP, RainSplashParticle.Factory::new);
		ParticleFactoryRegistry.getInstance().register(VariousStatusEffects.HIT_STUN_PARTICLE, DamageParticle.Factory::new);
	}
}
