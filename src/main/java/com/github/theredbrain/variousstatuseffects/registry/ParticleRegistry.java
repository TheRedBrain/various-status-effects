package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ParticleRegistry {

	public static void registerParticles() {
		VariousStatusEffects.BLOOD_DROP = FabricParticleTypes.simple();
		VariousStatusEffects.HIT_STUN_PARTICLE = FabricParticleTypes.simple();

		Registry.register(Registries.PARTICLE_TYPE, VariousStatusEffects.identifier("blood_drop"), VariousStatusEffects.BLOOD_DROP);
		Registry.register(Registries.PARTICLE_TYPE, VariousStatusEffects.identifier("hit_stun_particle"), VariousStatusEffects.HIT_STUN_PARTICLE);
	}
}
