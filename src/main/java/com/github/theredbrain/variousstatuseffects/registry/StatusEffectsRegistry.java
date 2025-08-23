package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.effect.AuraStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BeneficialStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BleedingStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BurningStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.CustomPoisonStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.HarmfulStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.InstantStaggerBuildUpStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.InstantStaminaLossStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.NeutralStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.ShockedInstantStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class StatusEffectsRegistry {

	public static final StatusEffect BLEEDING = new BleedingStatusEffect();
	public static final StatusEffect BURNING = new BurningStatusEffect();
	public static final StatusEffect CALAMITY = new NeutralStatusEffect();
	public static final StatusEffect CHILLED = new HarmfulStatusEffect();
	public static final StatusEffect CIVILISATION = new BeneficialStatusEffect();
	public static final StatusEffect FALL_IMMUNE = new BeneficialStatusEffect();
	public static final StatusEffect FROZEN = new HarmfulStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION = new BeneficialStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION_AURA = new AuraStatusEffect(StatusEffectCategory.BENEFICIAL, 3381504, true, true, true, 10, 80L, VariousStatusEffects.HEALTH_REGENERATION, 100, 0, true, false, true);
	public static final StatusEffect KEEP_INVENTORY = new BeneficialStatusEffect();
	public static final StatusEffect LAVA_IMMUNE = new BeneficialStatusEffect();
	public static final StatusEffect MANA_REGENERATION = new BeneficialStatusEffect();
	public static final StatusEffect NEEDS_TWO_HANDING = new NeutralStatusEffect();
	public static final StatusEffect NO_ATTACK_ITEM = new NeutralStatusEffect();
	public static final StatusEffect OVERBURDENED = new HarmfulStatusEffect();
	public static final StatusEffect LIGHT_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect MEDIUM_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect HEAVY_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect POISON = new CustomPoisonStatusEffect();
	public static final StatusEffect SHOCKED_INSTANT = new ShockedInstantStatusEffect();
	public static final StatusEffect SHOCKED_DAMAGE_INCREASE = new HarmfulStatusEffect();
	public static final StatusEffect STAGGERED = new HarmfulStatusEffect();
	public static final StatusEffect WET = new HarmfulStatusEffect();
	public static final StatusEffect WILDERNESS = new HarmfulStatusEffect();
	public static final StatusEffect HIT_STUN = new HarmfulStatusEffect();
	public static final StatusEffect INSTANT_STAMINA_LOSS = new InstantStaminaLossStatusEffect();
	public static final StatusEffect INSTANT_STAGGER_BUILD_UP = new InstantStaggerBuildUpStatusEffect();

	public static void registerEffects() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		// --- Attribute Modifiers ---
		CHILLED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.chilled_effect"), serverConfig.chilledSection.movement_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
				.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, VariousStatusEffects.identifier("effect.chilled_effect"), serverConfig.chilledSection.attack_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		OVERBURDENED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.overburdened_effect"), serverConfig.overburdenedSection.movement_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		HEAVY_LOAD
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.heavy_load_effect"), serverConfig.heavyLoadSection.movement_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		HIT_STUN
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.hit_stun_effect"), serverConfig.hitStunSection.movement_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
				.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, VariousStatusEffects.identifier("effect.hit_stun_effect"), serverConfig.hitStunSection.attack_speed_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		VariousStatusEffects.addModdedAttributesToEffects();

		// --- Configuration ---
		VariousStatusEffects.configureEffects();

		// --- Registration ---
		VariousStatusEffects.BLEEDING = register("bleeding", BLEEDING);
		VariousStatusEffects.BURNING = register("burning", BURNING);
		VariousStatusEffects.CALAMITY = register("calamity", CALAMITY);
		VariousStatusEffects.CIVILISATION = register("civilisation", CIVILISATION);
		VariousStatusEffects.CHILLED = register("chilled", CHILLED);
		VariousStatusEffects.FALL_IMMUNE = register("fall_immune", FALL_IMMUNE);
		VariousStatusEffects.FROZEN = register("frozen", FROZEN);
		VariousStatusEffects.HEALTH_REGENERATION = register("health_regeneration", HEALTH_REGENERATION);
		VariousStatusEffects.HEALTH_REGENERATION_AURA = register("health_regeneration_aura", HEALTH_REGENERATION_AURA);
		VariousStatusEffects.KEEP_INVENTORY = register("keep_inventory", KEEP_INVENTORY);
		VariousStatusEffects.LAVA_IMMUNE = register("lava_immune", LAVA_IMMUNE);
		VariousStatusEffects.MANA_REGENERATION = register("mana_regeneration", MANA_REGENERATION);
		VariousStatusEffects.NEEDS_TWO_HANDING = register("needs_two_handing", NEEDS_TWO_HANDING);
		VariousStatusEffects.NO_ATTACK_ITEM = register("no_attack_item", NO_ATTACK_ITEM);
		VariousStatusEffects.OVERBURDENED = register("overburdened", OVERBURDENED);
		VariousStatusEffects.POISON = register("poison", POISON);
		VariousStatusEffects.SHOCKED_INSTANT = register("shocked_instant", SHOCKED_INSTANT);
		VariousStatusEffects.SHOCKED_DAMAGE_INCREASE = register("shocked_damage_increase", SHOCKED_DAMAGE_INCREASE);
		VariousStatusEffects.STAGGERED = register("staggered", STAGGERED);
		VariousStatusEffects.WET = register("wet", WET);
		VariousStatusEffects.WILDERNESS = register("wilderness", WILDERNESS);
		VariousStatusEffects.LIGHT_LOAD = register("light_load", LIGHT_LOAD);
		VariousStatusEffects.MEDIUM_LOAD = register("medium_load", MEDIUM_LOAD);
		VariousStatusEffects.HEAVY_LOAD = register("heavy_load", HEAVY_LOAD);
		VariousStatusEffects.HIT_STUN = register("hit_stun", HIT_STUN);
		VariousStatusEffects.INSTANT_STAGGER_BUILD_UP = register("instant_stagger_build_up", INSTANT_STAGGER_BUILD_UP);
		VariousStatusEffects.INSTANT_STAMINA_LOSS = register("instant_stamina_loss", INSTANT_STAMINA_LOSS);
	}

	private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier(identifierString), statusEffect);
	}
}
