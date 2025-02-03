package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.spell.ParticleBatch;
import net.spell_engine.particle.ParticleHelper;

public class BleedingParticleSpawner implements CustomParticleStatusEffect.Spawner {
	private final ParticleBatch particles;

	public BleedingParticleSpawner(/*int particleCount*/) {
		this.particles = new ParticleBatch(
				"variousstatuseffects:blood_drop",
				ParticleBatch.Shape.SPHERE,
				ParticleBatch.Origin.CENTER,
				null,
				0.0F,
				0.0F,
				1,
				0.05F,
				0.08F,
				360,
				0.0F,
				0.0F,
				false
		);
	}

	@Override
	public void spawnParticles(LivingEntity livingEntity, int amplifier) {
//		var scaledParticles = new ParticleBatch(particles);
//		scaledParticles.count *= (1);
		ParticleHelper.play(livingEntity.getWorld(), livingEntity, new ParticleBatch(this.particles));
	}
}
