package com.github.theredbrain.variousstatuseffects.entity.damage;

import net.minecraft.entity.damage.DamageSource;

public interface DuckDamageSourcesMixin {
    DamageSource variousstatuseffects$bleeding();
    DamageSource variousstatuseffects$burning();
    DamageSource variousstatuseffects$poison();
    DamageSource variousstatuseffects$shocked();
}
