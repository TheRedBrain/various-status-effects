package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.combatrollextension.CombatRollExtension;
import com.github.theredbrain.foodoverhaul.effect.FoodStatusEffect;
import com.github.theredbrain.foodoverhaul.effect.RemoveFoodStatusEffect;
import com.github.theredbrain.healthregenerationoverhaul.HealthRegenerationOverhaul;
import com.github.theredbrain.manaattributes.ManaAttributes;
import com.github.theredbrain.overhauleddamage.OverhauledDamage;
import com.github.theredbrain.staminaattributes.StaminaAttributes;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.effect.AuraStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BeneficialStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BleedingStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BurningStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.CustomPoisonStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.HarmfulStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.NeutralStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.ShockedInstantStatusEffect;
import com.github.theredbrain.variousstatuseffects.spell_engine.ExtendedEntityActionsAllowedSemanticType;
import net.combat_roll.api.CombatRoll;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.spell_engine.api.effect.ActionImpairing;
import net.spell_engine.api.effect.EntityActionsAllowed;
import net.spell_engine.api.effect.Synchronized;

public class StatusEffectsRegistry {
	private static StatusEffect APPLE_FOOD_EFFECT;
	private static StatusEffect BAKED_POTATO_FOOD_EFFECT;
	private static StatusEffect BEEF_FOOD_EFFECT;
	private static StatusEffect BEETROOT_FOOD_EFFECT;
	private static StatusEffect BEETROOT_SOUP_FOOD_EFFECT;
	private static StatusEffect BREAD_FOOD_EFFECT;
	private static StatusEffect BROWN_MUSHROOM_FOOD_EFFECT;
	private static StatusEffect CAKE_FOOD_EFFECT;
	private static StatusEffect CARROT_FOOD_EFFECT;
	private static StatusEffect CHICKEN_FOOD_EFFECT;
	private static StatusEffect CHORUS_FRUIT_FOOD_EFFECT;
	private static StatusEffect COCOA_BEANS_FOOD_EFFECT;
	private static StatusEffect COD_FOOD_EFFECT;
	private static StatusEffect COOKED_BEEF_FOOD_EFFECT;
	private static StatusEffect COOKED_CHICKEN_FOOD_EFFECT;
	private static StatusEffect COOKED_COD_FOOD_EFFECT;
	private static StatusEffect COOKED_MUTTON_FOOD_EFFECT;
	private static StatusEffect COOKED_PORKCHOP_FOOD_EFFECT;
	private static StatusEffect COOKED_RABBIT_FOOD_EFFECT;
	private static StatusEffect COOKED_SALMON_FOOD_EFFECT;
	private static StatusEffect COOKIE_FOOD_EFFECT;
	private static StatusEffect DRIED_KELP_FOOD_EFFECT;
	private static StatusEffect ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT;
	private static StatusEffect FERMENTED_SPIDER_EYE_FOOD_EFFECT;
	private static StatusEffect GLOW_BERRIES_FOOD_EFFECT;
	private static StatusEffect GOLDEN_APPLE_FOOD_EFFECT;
	private static StatusEffect GOLDEN_CARROT_FOOD_EFFECT;
	private static StatusEffect HONEY_BOTTLE_FOOD_EFFECT;
	private static StatusEffect MELON_SLICE_FOOD_EFFECT;
	private static StatusEffect MUSHROOM_STEW_FOOD_EFFECT;
	private static StatusEffect MUTTON_FOOD_EFFECT;
	private static StatusEffect POISONOUS_POTATO_FOOD_EFFECT;
	private static StatusEffect PORKCHOP_FOOD_EFFECT;
	private static StatusEffect POTATO_FOOD_EFFECT;
	private static StatusEffect PUFFERFISH_FOOD_EFFECT;
	private static StatusEffect PUMPKIN_PIE_FOOD_EFFECT;
	private static StatusEffect RABBIT_FOOD_EFFECT;
	private static StatusEffect RABBIT_STEW_FOOD_EFFECT;
	private static StatusEffect RED_MUSHROOM_FOOD_EFFECT;
	private static StatusEffect ROTTEN_FLESH_FOOD_EFFECT;
	private static StatusEffect SALMON_FOOD_EFFECT;
	private static StatusEffect SPIDER_EYE_FOOD_EFFECT;
	private static StatusEffect SUGAR_FOOD_EFFECT;
	private static StatusEffect SUSPICIOUS_STEW_FOOD_EFFECT;
	private static StatusEffect SWEET_BERRIES_FOOD_EFFECT;
	private static StatusEffect TROPICAL_FISH_FOOD_EFFECT;

	//region
	private static final StatusEffect BLEEDING = new BleedingStatusEffect();
	private static final StatusEffect BURNING = new BurningStatusEffect();
	private static final StatusEffect CALAMITY = new NeutralStatusEffect();
	private static final StatusEffect CHILLED = new HarmfulStatusEffect();
	private static final StatusEffect CIVILISATION = new BeneficialStatusEffect();
	private static final StatusEffect FALL_IMMUNE = new BeneficialStatusEffect();
	private static final StatusEffect FROZEN = new HarmfulStatusEffect();
	private static final StatusEffect HEALTH_REGENERATION = new BeneficialStatusEffect();
	private static final StatusEffect HEALTH_REGENERATION_AURA = new AuraStatusEffect(true, true, VariousStatusEffects.HEALTH_REGENERATION, 100, 0, true, false, true);
	private static final StatusEffect KEEP_INVENTORY = new BeneficialStatusEffect();
	private static final StatusEffect LAVA_IMMUNE = new BeneficialStatusEffect();
	private static final StatusEffect MANA_REGENERATION = new BeneficialStatusEffect();
	private static final StatusEffect NEEDS_TWO_HANDING = new NeutralStatusEffect();
	private static final StatusEffect NO_ATTACK_ITEM = new NeutralStatusEffect();
	private static final StatusEffect OVERBURDENED = new HarmfulStatusEffect();
	private static final StatusEffect LIGHT_LOAD = new HarmfulStatusEffect();
	private static final StatusEffect MEDIUM_LOAD = new HarmfulStatusEffect();
	private static final StatusEffect HEAVY_LOAD = new HarmfulStatusEffect();
	private static final StatusEffect POISON = new CustomPoisonStatusEffect();
	private static final StatusEffect SHOCKED_INSTANT = new ShockedInstantStatusEffect();
	private static final StatusEffect SHOCKED_DAMAGE_INCREASE = new HarmfulStatusEffect();
	private static final StatusEffect STAGGERED = new HarmfulStatusEffect();
	private static final StatusEffect WET = new HarmfulStatusEffect();
	private static final StatusEffect WILDERNESS = new HarmfulStatusEffect();
	// endregion

	public static void registerEffects() {
		// region --- Initialize Food Effects ---
		if (VariousStatusEffects.isFoodOverhaulLoaded) {
			VariousStatusEffects.LOGGER.info("VariousStatusEffects.isFoodOverhaulLoaded");
			APPLE_FOOD_EFFECT = new FoodStatusEffect();
			BAKED_POTATO_FOOD_EFFECT = new FoodStatusEffect();
			BEEF_FOOD_EFFECT = new FoodStatusEffect();
			BEETROOT_FOOD_EFFECT = new FoodStatusEffect();
			BEETROOT_SOUP_FOOD_EFFECT = new FoodStatusEffect();
			BREAD_FOOD_EFFECT = new FoodStatusEffect();
			BROWN_MUSHROOM_FOOD_EFFECT = new FoodStatusEffect();
			CAKE_FOOD_EFFECT = new FoodStatusEffect();
			CARROT_FOOD_EFFECT = new FoodStatusEffect();
			CHICKEN_FOOD_EFFECT = new FoodStatusEffect();
			CHORUS_FRUIT_FOOD_EFFECT = new FoodStatusEffect();
			COCOA_BEANS_FOOD_EFFECT = new FoodStatusEffect();
			COD_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_BEEF_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_CHICKEN_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_COD_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_MUTTON_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_PORKCHOP_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_RABBIT_FOOD_EFFECT = new FoodStatusEffect();
			COOKED_SALMON_FOOD_EFFECT = new FoodStatusEffect();
			COOKIE_FOOD_EFFECT = new FoodStatusEffect();
			DRIED_KELP_FOOD_EFFECT = new FoodStatusEffect();
			ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT = new FoodStatusEffect();
			FERMENTED_SPIDER_EYE_FOOD_EFFECT = new FoodStatusEffect();
			GLOW_BERRIES_FOOD_EFFECT = new FoodStatusEffect();
			GOLDEN_APPLE_FOOD_EFFECT = new FoodStatusEffect();
			GOLDEN_CARROT_FOOD_EFFECT = new FoodStatusEffect();
			HONEY_BOTTLE_FOOD_EFFECT = new FoodStatusEffect();
			MELON_SLICE_FOOD_EFFECT = new FoodStatusEffect();
			MUSHROOM_STEW_FOOD_EFFECT = new FoodStatusEffect();
			MUTTON_FOOD_EFFECT = new FoodStatusEffect();
			POISONOUS_POTATO_FOOD_EFFECT = new FoodStatusEffect();
			PORKCHOP_FOOD_EFFECT = new FoodStatusEffect();
			POTATO_FOOD_EFFECT = new FoodStatusEffect();
			PUFFERFISH_FOOD_EFFECT = new FoodStatusEffect();
			PUMPKIN_PIE_FOOD_EFFECT = new FoodStatusEffect();
			RABBIT_FOOD_EFFECT = new FoodStatusEffect();
			RABBIT_STEW_FOOD_EFFECT = new FoodStatusEffect();
			RED_MUSHROOM_FOOD_EFFECT = new FoodStatusEffect();
			ROTTEN_FLESH_FOOD_EFFECT = new RemoveFoodStatusEffect();
			SALMON_FOOD_EFFECT = new FoodStatusEffect();
			SPIDER_EYE_FOOD_EFFECT = new FoodStatusEffect();
			SUGAR_FOOD_EFFECT = new FoodStatusEffect();
			SUSPICIOUS_STEW_FOOD_EFFECT = new FoodStatusEffect();
			SWEET_BERRIES_FOOD_EFFECT = new FoodStatusEffect();
			TROPICAL_FISH_FOOD_EFFECT = new FoodStatusEffect();
		} else {
			VariousStatusEffects.LOGGER.info("!VariousStatusEffects.isFoodOverhaulLoaded");
			APPLE_FOOD_EFFECT = new BeneficialStatusEffect();
			BAKED_POTATO_FOOD_EFFECT = new BeneficialStatusEffect();
			BEEF_FOOD_EFFECT = new BeneficialStatusEffect();
			BEETROOT_FOOD_EFFECT = new BeneficialStatusEffect();
			BEETROOT_SOUP_FOOD_EFFECT = new BeneficialStatusEffect();
			BREAD_FOOD_EFFECT = new BeneficialStatusEffect();
			BROWN_MUSHROOM_FOOD_EFFECT = new BeneficialStatusEffect();
			CAKE_FOOD_EFFECT = new BeneficialStatusEffect();
			CARROT_FOOD_EFFECT = new BeneficialStatusEffect();
			CHICKEN_FOOD_EFFECT = new BeneficialStatusEffect();
			CHORUS_FRUIT_FOOD_EFFECT = new BeneficialStatusEffect();
			COCOA_BEANS_FOOD_EFFECT = new BeneficialStatusEffect();
			COD_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_BEEF_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_CHICKEN_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_COD_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_MUTTON_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_PORKCHOP_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_RABBIT_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKED_SALMON_FOOD_EFFECT = new BeneficialStatusEffect();
			COOKIE_FOOD_EFFECT = new BeneficialStatusEffect();
			DRIED_KELP_FOOD_EFFECT = new BeneficialStatusEffect();
			ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT = new BeneficialStatusEffect();
			FERMENTED_SPIDER_EYE_FOOD_EFFECT = new BeneficialStatusEffect();
			GLOW_BERRIES_FOOD_EFFECT = new BeneficialStatusEffect();
			GOLDEN_APPLE_FOOD_EFFECT = new BeneficialStatusEffect();
			GOLDEN_CARROT_FOOD_EFFECT = new BeneficialStatusEffect();
			HONEY_BOTTLE_FOOD_EFFECT = new BeneficialStatusEffect();
			MELON_SLICE_FOOD_EFFECT = new BeneficialStatusEffect();
			MUSHROOM_STEW_FOOD_EFFECT = new BeneficialStatusEffect();
			MUTTON_FOOD_EFFECT = new BeneficialStatusEffect();
			POISONOUS_POTATO_FOOD_EFFECT = new BeneficialStatusEffect();
			PORKCHOP_FOOD_EFFECT = new BeneficialStatusEffect();
			POTATO_FOOD_EFFECT = new BeneficialStatusEffect();
			PUFFERFISH_FOOD_EFFECT = new BeneficialStatusEffect();
			PUMPKIN_PIE_FOOD_EFFECT = new BeneficialStatusEffect();
			RABBIT_FOOD_EFFECT = new BeneficialStatusEffect();
			RABBIT_STEW_FOOD_EFFECT = new BeneficialStatusEffect();
			RED_MUSHROOM_FOOD_EFFECT = new BeneficialStatusEffect();
			ROTTEN_FLESH_FOOD_EFFECT = new BeneficialStatusEffect();
			SALMON_FOOD_EFFECT = new BeneficialStatusEffect();
			SPIDER_EYE_FOOD_EFFECT = new BeneficialStatusEffect();
			SUGAR_FOOD_EFFECT = new BeneficialStatusEffect();
			SUSPICIOUS_STEW_FOOD_EFFECT = new BeneficialStatusEffect();
			SWEET_BERRIES_FOOD_EFFECT = new BeneficialStatusEffect();
			TROPICAL_FISH_FOOD_EFFECT = new BeneficialStatusEffect();
		}
		// endregion --- Initialize Food Effects ---

		// --- Attribute Modifiers ---
		// region food effects
		APPLE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.apple_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			APPLE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.apple_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			APPLE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.apple_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.apple_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BAKED_POTATO_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.baked_potato_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BAKED_POTATO_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.baked_potato_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BAKED_POTATO_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.baked_potato_food_effect"), 7.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.baked_potato_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BEEF_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.beef_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BEEF_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.beef_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BEEF_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.beef_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.beef_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BEETROOT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.beetroot_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BEETROOT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.beetroot_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BEETROOT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.beetroot_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.beetroot_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BEETROOT_SOUP_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.beetroot_soup_food_effect"), 15.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BEETROOT_SOUP_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.beetroot_soup_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BEETROOT_SOUP_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.beetroot_soup_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.beetroot_soup_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			BEETROOT_SOUP_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.FROST_RESISTANCE, VariousStatusEffects.identifier("effect.beetroot_soup_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BREAD_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.bread_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BREAD_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.bread_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BREAD_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.bread_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.bread_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		BROWN_MUSHROOM_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.brown_mushroom_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			BROWN_MUSHROOM_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.brown_mushroom_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			BROWN_MUSHROOM_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.brown_mushroom_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.brown_mushroom_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		CAKE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cake_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			CAKE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cake_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			CAKE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cake_food_effect"), 25.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cake_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		CARROT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.carrot_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			CARROT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.carrot_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			CARROT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.carrot_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.carrot_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		CHICKEN_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.chicken_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			CHICKEN_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.chicken_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			CHICKEN_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.chicken_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			CHICKEN_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.chicken_food_effect"), -2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		CHORUS_FRUIT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.chorus_fruit_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			CHORUS_FRUIT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.chorus_fruit_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			CHORUS_FRUIT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.chorus_fruit_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.chorus_fruit_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COCOA_BEANS_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cocoa_beans_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COCOA_BEANS_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cocoa_beans_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COCOA_BEANS_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cocoa_beans_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cocoa_beans_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COD_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cod_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COD_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cod_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COD_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cod_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cod_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			COD_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.cod_food_effect"), -2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_BEEF_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_beef_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_BEEF_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_beef_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_BEEF_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_beef_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_beef_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_CHICKEN_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_chicken_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_CHICKEN_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_chicken_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_CHICKEN_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_chicken_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_chicken_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_COD_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_cod_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_COD_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_cod_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_COD_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_cod_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_cod_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_MUTTON_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_mutton_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_MUTTON_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_mutton_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_MUTTON_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_mutton_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_mutton_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_PORKCHOP_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_porkchop_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_PORKCHOP_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_porkchop_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_PORKCHOP_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_porkchop_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_porkchop_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_RABBIT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_rabbit_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_RABBIT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_rabbit_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_RABBIT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_rabbit_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_rabbit_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKED_SALMON_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cooked_salmon_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKED_SALMON_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cooked_salmon_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKED_SALMON_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cooked_salmon_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cooked_salmon_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		COOKIE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.cookie_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			COOKIE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.cookie_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			COOKIE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.cookie_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.cookie_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		DRIED_KELP_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.dried_kelp_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			DRIED_KELP_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.dried_kelp_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			DRIED_KELP_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION_DELAY_THRESHOLD, VariousStatusEffects.identifier("effect.dried_kelp_food_effect"), -30.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_TICK_THRESHOLD, VariousStatusEffects.identifier("effect.dried_kelp_food_effect"), -10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.enchanted_golden_apple_food_effect"), 15.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.enchanted_golden_apple_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.enchanted_golden_apple_food_effect"), 30.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.enchanted_golden_apple_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isManaAttributesLoaded) {
			FERMENTED_SPIDER_EYE_FOOD_EFFECT
					.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.fermented_spider_eye_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.fermented_spider_eye_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		GLOW_BERRIES_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.glow_berries_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			GLOW_BERRIES_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.glow_berries_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.glow_berries_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isManaAttributesLoaded) {
			GLOW_BERRIES_FOOD_EFFECT
					.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.glow_berries_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.glow_berries_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		GOLDEN_APPLE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.golden_apple_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			GOLDEN_APPLE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.golden_apple_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			GOLDEN_APPLE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.golden_apple_food_effect"), 50.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.golden_apple_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		GOLDEN_CARROT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.golden_carrot_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			GOLDEN_CARROT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.golden_carrot_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			GOLDEN_CARROT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.golden_carrot_food_effect"), 50.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.golden_carrot_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			HONEY_BOTTLE_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.MAX_POISON_BUILD_UP, VariousStatusEffects.identifier("effect.honey_bottle_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.honey_bottle_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		MELON_SLICE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.melon_slice_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			MELON_SLICE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.melon_slice_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			MELON_SLICE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.melon_slice_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.melon_slice_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		MUSHROOM_STEW_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.mushroom_stew_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			MUSHROOM_STEW_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.mushroom_stew_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			MUSHROOM_STEW_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.mushroom_stew_food_effect"), 15.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.mushroom_stew_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		MUTTON_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.mutton_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			MUTTON_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.mutton_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			MUTTON_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.mutton_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.mutton_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			POISONOUS_POTATO_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.poisonous_potato_food_effect"), -3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		PORKCHOP_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.porkchop_porkchop_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			PORKCHOP_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.porkchop_porkchop_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			PORKCHOP_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.porkchop_porkchop_food_effect"), -2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		POTATO_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.potato_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			POTATO_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.potato_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			POTATO_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.potato_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.potato_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			PUFFERFISH_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.pufferfish_food_effect"), -5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		PUMPKIN_PIE_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.pumpkin_pie_food_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			PUMPKIN_PIE_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.pumpkin_pie_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			PUMPKIN_PIE_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.pumpkin_pie_food_effect"), 15.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.pumpkin_pie_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		RABBIT_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.rabbit_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			RABBIT_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.rabbit_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			RABBIT_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.rabbit_food_effect"), 20.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.rabbit_food_effect"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		RABBIT_STEW_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.rabbit_stew_food_effect"), 15.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			RABBIT_STEW_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.rabbit_stew_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			RABBIT_STEW_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.rabbit_stew_food_effect"), 7.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.rabbit_stew_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isManaAttributesLoaded) {
			RED_MUSHROOM_FOOD_EFFECT
					.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.red_mushroom_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			RED_MUSHROOM_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.red_mushroom_food_effect"), -4.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		SALMON_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.salmon_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			SALMON_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.salmon_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			SALMON_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.salmon_food_effect"), -2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			SPIDER_EYE_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.spider_eye_food_effect"), -3.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		SUGAR_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.sugar_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			SUGAR_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.sugar_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			SUGAR_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.sugar_food_effect"), 25.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.sugar_food_effect"), 4.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		SUSPICIOUS_STEW_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.suspicious_stew_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			SUSPICIOUS_STEW_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.suspicious_stew_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			SUSPICIOUS_STEW_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.suspicious_stew_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isManaAttributesLoaded) {
			SUSPICIOUS_STEW_FOOD_EFFECT
					.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.suspicious_stew_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		SWEET_BERRIES_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.sweet_berries_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			SWEET_BERRIES_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.sweet_berries_food_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			SWEET_BERRIES_FOOD_EFFECT
					.addAttributeModifier(StaminaAttributes.MAX_STAMINA, VariousStatusEffects.identifier("effect.sweet_berries_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.sweet_berries_food_effect"), 1.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}

		TROPICAL_FISH_FOOD_EFFECT
				.addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, VariousStatusEffects.identifier("effect.tropical_fish_food_effect"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			TROPICAL_FISH_FOOD_EFFECT
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.tropical_fish_food_effect"), 0.5F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isOverhauledDamageLoaded) {
			TROPICAL_FISH_FOOD_EFFECT
					.addAttributeModifier(OverhauledDamage.POISON_BUILD_UP_REDUCTION, VariousStatusEffects.identifier("effect.tropical_fish_food_effect"), -2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		// endregion food effects
		// region other effects
		CHILLED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.chilled_effect"), -0.15F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
				.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, VariousStatusEffects.identifier("effect.chilled_effect"), -0.15F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		if (VariousStatusEffects.isHealthRegenerationOverhaulLoaded) {
			HEALTH_REGENERATION
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.health_regeneration_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
			CIVILISATION
					.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isStaminaAttributesLoaded) {
			CIVILISATION
					.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isManaAttributesLoaded) {
			CIVILISATION
					.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
			HEALTH_REGENERATION_AURA
					.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.health_regeneration_aura_effect"), -0.25F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
			;
			MANA_REGENERATION
					.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.mana_regeneration_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		OVERBURDENED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.overburdened_effect"), -0.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
//		if (VariousStatusEffects.isOverhauledDamageLoaded) {
//        SHOCKED_DAMAGE_INCREASE
//                .addAttributeModifier(OverhauledDamage.DAMAGE_TAKEN_MULTIPLIER, VariousStatusEffects.identifier("effect.shocked_damage_increase_effect"), 0.25, EntityAttributeModifier.Operation.ADD_VALUE)
//        ;
//		}
		if (VariousStatusEffects.isCombatRollExtensionLoaded) {
			LIGHT_LOAD
					.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.light_load_effect"), 7.0, EntityAttributeModifier.Operation.ADD_VALUE)
			;
			MEDIUM_LOAD
					.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.medium_load_effect"), 6.0, EntityAttributeModifier.Operation.ADD_VALUE)
			;
			HEAVY_LOAD
					.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.heavy_load_effect"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		if (VariousStatusEffects.isCombatRollLoaded) {
			HEAVY_LOAD
					.addAttributeModifier(CombatRoll.Attributes.DISTANCE.entry, VariousStatusEffects.identifier("effect.heavy_load_effect"), -1.0, EntityAttributeModifier.Operation.ADD_VALUE)
			;
		}
		HEAVY_LOAD
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.heavy_load_effect"), -0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		// endregion other effects

		// --- Configuration ---
		if (VariousStatusEffects.isSpellEngineLoaded) {
			ActionImpairing.configure(NO_ATTACK_ITEM, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, true, true), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NO_ATTACK_ITEM));
			ActionImpairing.configure(NEEDS_TWO_HANDING, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NEEDS_TWO_HANDING));
			ActionImpairing.configure(STAGGERED, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.STAGGERED));
			ActionImpairing.configure(OVERBURDENED, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(true, true, true), new EntityActionsAllowed.MobsAllowed(true), EntityActionsAllowed.SemanticType.NONE));
			ActionImpairing.configure(FROZEN, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.FROZEN));

			Synchronized.configure(BURNING, true);
			Synchronized.configure(CHILLED, true);
			Synchronized.configure(FROZEN, true);
			Synchronized.configure(HEALTH_REGENERATION_AURA, true);
			Synchronized.configure(STAGGERED, true);
			Synchronized.configure(WET, true);
		}

		// --- Registration ---
		// food effects
		VariousStatusEffects.APPLE_FOOD_EFFECT = register("apple_food_effect", APPLE_FOOD_EFFECT);
		VariousStatusEffects.BAKED_POTATO_FOOD_EFFECT = register("baked_potato_food_effect", BAKED_POTATO_FOOD_EFFECT);
		VariousStatusEffects.BEEF_FOOD_EFFECT = register("beef_food_effect", BEEF_FOOD_EFFECT);
		VariousStatusEffects.BEETROOT_FOOD_EFFECT = register("beetroot_food_effect", BEETROOT_FOOD_EFFECT);
		VariousStatusEffects.BEETROOT_SOUP_FOOD_EFFECT = register("beetroot_soup_food_effect", BEETROOT_SOUP_FOOD_EFFECT);
		VariousStatusEffects.BREAD_FOOD_EFFECT = register("bread_food_effect", BREAD_FOOD_EFFECT);
		VariousStatusEffects.BROWN_MUSHROOM_FOOD_EFFECT = register("brown_mushroom_food_effect", BROWN_MUSHROOM_FOOD_EFFECT);
		VariousStatusEffects.CAKE_FOOD_EFFECT = register("cake_food_effect", CAKE_FOOD_EFFECT);
		VariousStatusEffects.CARROT_FOOD_EFFECT = register("carrot_food_effect", CARROT_FOOD_EFFECT);
		VariousStatusEffects.CHICKEN_FOOD_EFFECT = register("chicken_food_effect", CHICKEN_FOOD_EFFECT);
		VariousStatusEffects.CHORUS_FRUIT_FOOD_EFFECT = register("chorus_fruit_food_effect", CHORUS_FRUIT_FOOD_EFFECT);
		VariousStatusEffects.COCOA_BEANS_FOOD_EFFECT = register("cocoa_beans_food_effect", COCOA_BEANS_FOOD_EFFECT);
		VariousStatusEffects.COD_FOOD_EFFECT = register("cod_food_effect", COD_FOOD_EFFECT);
		VariousStatusEffects.COOKED_BEEF_FOOD_EFFECT = register("cooked_beef_food_effect", COOKED_BEEF_FOOD_EFFECT);
		VariousStatusEffects.COOKED_CHICKEN_FOOD_EFFECT = register("cooked_chicken_food_effect", COOKED_CHICKEN_FOOD_EFFECT);
		VariousStatusEffects.COOKED_COD_FOOD_EFFECT = register("cooked_cod_food_effect", COOKED_COD_FOOD_EFFECT);
		VariousStatusEffects.COOKED_MUTTON_FOOD_EFFECT = register("cooked_mutton_food_effect", COOKED_MUTTON_FOOD_EFFECT);
		VariousStatusEffects.COOKED_PORKCHOP_FOOD_EFFECT = register("cooked_porkchop_food_effect", COOKED_PORKCHOP_FOOD_EFFECT);
		VariousStatusEffects.COOKED_RABBIT_FOOD_EFFECT = register("cooked_rabbit_food_effect", COOKED_RABBIT_FOOD_EFFECT);
		VariousStatusEffects.COOKED_SALMON_FOOD_EFFECT = register("cooked_salmon_food_effect", COOKED_SALMON_FOOD_EFFECT);
		VariousStatusEffects.COOKIE_FOOD_EFFECT = register("cookie_food_effect", COOKIE_FOOD_EFFECT);
		VariousStatusEffects.DRIED_KELP_FOOD_EFFECT = register("dried_kelp_food_effect", DRIED_KELP_FOOD_EFFECT);
		VariousStatusEffects.ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT = register("enchanted_golden_apple_food_effect", ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT);
		VariousStatusEffects.FERMENTED_SPIDER_EYE_FOOD_EFFECT = register("fermented_spider_eye_food_effect", FERMENTED_SPIDER_EYE_FOOD_EFFECT);
		VariousStatusEffects.GLOW_BERRIES_FOOD_EFFECT = register("glow_berries_food_effect", GLOW_BERRIES_FOOD_EFFECT);
		VariousStatusEffects.GOLDEN_APPLE_FOOD_EFFECT = register("golden_apple_food_effect", GOLDEN_APPLE_FOOD_EFFECT);
		VariousStatusEffects.GOLDEN_CARROT_FOOD_EFFECT = register("golden_carrot_food_effect", GOLDEN_CARROT_FOOD_EFFECT);
		VariousStatusEffects.HONEY_BOTTLE_FOOD_EFFECT = register("honey_bottle_food_effect", HONEY_BOTTLE_FOOD_EFFECT);
		VariousStatusEffects.MELON_SLICE_FOOD_EFFECT = register("melon_slice_food_effect", MELON_SLICE_FOOD_EFFECT);
		VariousStatusEffects.MUSHROOM_STEW_FOOD_EFFECT = register("mushroom_stew_food_effect", MUSHROOM_STEW_FOOD_EFFECT);
		VariousStatusEffects.MUTTON_FOOD_EFFECT = register("mutton_food_effect", MUTTON_FOOD_EFFECT);
		VariousStatusEffects.POISONOUS_POTATO_FOOD_EFFECT = register("poisonous_potato_food_effect", POISONOUS_POTATO_FOOD_EFFECT);
		VariousStatusEffects.PORKCHOP_FOOD_EFFECT = register("porkchop_porkchop_food_effect", PORKCHOP_FOOD_EFFECT);
		VariousStatusEffects.POTATO_FOOD_EFFECT = register("potato_food_effect", POTATO_FOOD_EFFECT);
		VariousStatusEffects.PUFFERFISH_FOOD_EFFECT = register("pufferfish_food_effect", PUFFERFISH_FOOD_EFFECT);
		VariousStatusEffects.PUMPKIN_PIE_FOOD_EFFECT = register("pumpkin_pie_food_effect", PUMPKIN_PIE_FOOD_EFFECT);
		VariousStatusEffects.RABBIT_FOOD_EFFECT = register("rabbit_food_effect", RABBIT_FOOD_EFFECT);
		VariousStatusEffects.RABBIT_STEW_FOOD_EFFECT = register("rabbit_stew_food_effect", RABBIT_STEW_FOOD_EFFECT);
		VariousStatusEffects.RED_MUSHROOM_FOOD_EFFECT = register("red_mushroom_food_effect", RED_MUSHROOM_FOOD_EFFECT);
		VariousStatusEffects.ROTTEN_FLESH_FOOD_EFFECT = register("rotten_flesh_food_effect", ROTTEN_FLESH_FOOD_EFFECT);
		VariousStatusEffects.SALMON_FOOD_EFFECT = register("salmon_food_effect", SALMON_FOOD_EFFECT);
		VariousStatusEffects.SPIDER_EYE_FOOD_EFFECT = register("spider_eye_food_effect", SPIDER_EYE_FOOD_EFFECT);
		VariousStatusEffects.SUGAR_FOOD_EFFECT = register("sugar_food_effect", SUGAR_FOOD_EFFECT);
		VariousStatusEffects.SUSPICIOUS_STEW_FOOD_EFFECT = register("suspicious_stew_food_effect", SUSPICIOUS_STEW_FOOD_EFFECT);
		VariousStatusEffects.SWEET_BERRIES_FOOD_EFFECT = register("sweet_berries_food_effect", SWEET_BERRIES_FOOD_EFFECT);
		VariousStatusEffects.TROPICAL_FISH_FOOD_EFFECT = register("tropical_fish_food_effect", TROPICAL_FISH_FOOD_EFFECT);

		// other effects
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
	}

	private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
		return Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier(identifierString), statusEffect);
	}
}
