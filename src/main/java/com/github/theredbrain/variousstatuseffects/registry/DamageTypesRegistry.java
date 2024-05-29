package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class DamageTypesRegistry {

    public static final RegistryKey<DamageType> BLEEDING_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, VariousStatusEffects.identifier("bleeding_damage_type"));
    public static final RegistryKey<DamageType> BURNING_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, VariousStatusEffects.identifier("burning_damage_type"));
    public static final RegistryKey<DamageType> POISON_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, VariousStatusEffects.identifier("poison_damage_type"));
    public static final RegistryKey<DamageType> SHOCKED_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, VariousStatusEffects.identifier("shocked_damage_type"));
}
