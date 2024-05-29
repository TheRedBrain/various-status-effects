package com.github.theredbrain.variousstatuseffects.effect;

import com.github.theredbrain.variousstatuseffects.entity.DuckLivingEntityMixin;
import com.github.theredbrain.variousstatuseffects.entity.damage.DuckDamageSourcesMixin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;

public class BleedingStatusEffect extends HarmfulStatusEffect { // TODO play test balance
    public BleedingStatusEffect() {
        super();
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (!entity.getEntityWorld().isClient) {
            boolean isMoving = ((DuckLivingEntityMixin)entity).overhauleddamage$isMoving();
            float bleedingDamage = Math.max(1.0f, (float) (entity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH) * 0.1f)) * (isMoving ? 2 : 1);
            entity.damage(((DuckDamageSourcesMixin)entity.getDamageSources()).variousstatuseffects$bleeding(), bleedingDamage);
        }
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 1;
    }
}
