package com.github.theredbrain.variousstatuseffects.effect;

import net.minecraft.entity.LivingEntity;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
import net.spell_engine.api.spell.fx.ParticleBatch;
import net.spell_engine.fx.ParticleHelper;

public class HitStunParticleSpawner implements CustomParticleStatusEffect.Spawner {
	private final ParticleBatch particles;

	public HitStunParticleSpawner(/*int particleCount*/) {
		this.particles = new ParticleBatch(
				"variousstatuseffects:hit_stun_particle",
				ParticleBatch.Shape.CIRCLE,
				ParticleBatch.Origin.LAUNCH_POINT,
				null,
				0.0F,
				0.0F,
				1,
				0.002F,
				0.01F,
				360,
				0.5F,
				0.1F,
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
