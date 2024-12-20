package com.github.theredbrain.variousstatuseffects.mixin.entity;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.entity.DuckLivingEntityMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements DuckLivingEntityMixin {

    @Unique
    private double oldPosX = 0.0;
    @Unique
    private double oldPosY = 0.0;
    @Unique
    private double oldPosZ = 0.0;
    @Unique
    private boolean isMoving = false;
    @Shadow
    public abstract boolean addStatusEffect(StatusEffectInstance effect);

    @Shadow public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

    @Shadow public abstract @Nullable StatusEffectInstance getStatusEffect(RegistryEntry<StatusEffect> effect);

    @Shadow public abstract boolean removeStatusEffect(RegistryEntry<StatusEffect> effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    public boolean doesRenderOnFire() {
        return super.doesRenderOnFire() || (this.hasStatusEffect(VariousStatusEffects.BURNING) && !this.isSpectator());
    }

    @Override
    public void updateSwimming() {
        if (this.isSwimming()) {
            this.setSwimming(!this.hasStatusEffect(VariousStatusEffects.OVERBURDENED) && this.isSprinting() && this.isTouchingWater() && !this.hasVehicle());
        } else {
            this.setSwimming(!this.hasStatusEffect(VariousStatusEffects.OVERBURDENED) && this.isSprinting() && this.isSubmergedInWater() && !this.hasVehicle() && this.getWorld().getFluidState(this.getBlockPos()).isIn(FluidTags.WATER));
        }
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void overhauleddamage$tick(CallbackInfo ci) {
        if (!this.getWorld().isClient) {

            this.isMoving = this.oldPosX != this.getX() || this.oldPosY != this.getY() || this.oldPosZ != this.getZ();
            this.oldPosX = this.getX();
            this.oldPosY = this.getY();
            this.oldPosZ = this.getZ();

            StatusEffectInstance burningStatusEffectInstance = this.getStatusEffect(VariousStatusEffects.BURNING);
            if (burningStatusEffectInstance != null && this.isTouchingWaterOrRain()) {
                int oldBurnDuration = burningStatusEffectInstance.getDuration();
                this.removeStatusEffect(VariousStatusEffects.BURNING);
                this.addStatusEffect(new StatusEffectInstance(VariousStatusEffects.BURNING, oldBurnDuration - 5, 0, false, false, true));
            }

        }
    }

    @Override
    public boolean overhauleddamage$isMoving() {
        return this.isMoving;
    }
}
