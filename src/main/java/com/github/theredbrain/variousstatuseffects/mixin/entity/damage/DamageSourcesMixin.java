package com.github.theredbrain.variousstatuseffects.mixin.entity.damage;

import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import com.github.theredbrain.variousstatuseffects.registry.DamageTypesRegistry;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DamageSources.class)
public abstract class DamageSourcesMixin implements DuckDamageSourcesMixin {

	@Shadow
	public abstract DamageSource create(RegistryKey<DamageType> key);

	@Override
	public DamageSource variousstatuseffects$bleeding() {
		return this.create(DamageTypesRegistry.BLEEDING_DAMAGE_TYPE);
	}

	@Override
	public DamageSource variousstatuseffects$burning() {
		return this.create(DamageTypesRegistry.BURNING_DAMAGE_TYPE);
	}

	@Override
	public DamageSource variousstatuseffects$poison() {
		return this.create(DamageTypesRegistry.POISON_DAMAGE_TYPE);
	}

	@Override
	public DamageSource variousstatuseffects$shocked() {
		return this.create(DamageTypesRegistry.SHOCKED_DAMAGE_TYPE);
	}
}
