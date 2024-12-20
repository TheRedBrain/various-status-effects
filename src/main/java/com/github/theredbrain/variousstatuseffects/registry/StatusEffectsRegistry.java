package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.combatrollextension.CombatRollExtension;
import com.github.theredbrain.healthregenerationoverhaul.HealthRegenerationOverhaul;
import com.github.theredbrain.manaattributes.ManaAttributes;
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
import net.spell_engine.api.effect.ActionImpairing;
import net.spell_engine.api.effect.EntityActionsAllowed;
import net.spell_engine.api.effect.Synchronized;

public class StatusEffectsRegistry {
	public static final StatusEffect BLEEDING = new BleedingStatusEffect();
	public static final StatusEffect BURNING = new BurningStatusEffect();
	public static final StatusEffect CALAMITY = new NeutralStatusEffect();
	private static final StatusEffect CHILLED = new HarmfulStatusEffect();
	public static final StatusEffect CIVILISATION = new BeneficialStatusEffect();
	public static final StatusEffect FALL_IMMUNE = new BeneficialStatusEffect();
	public static final StatusEffect FROZEN = new HarmfulStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION = new BeneficialStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION_AURA = new AuraStatusEffect(true, true, VariousStatusEffects.HEALTH_REGENERATION, 100, 0, true, false, true);
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

	public static void registerEffects() {
		// --- Attribute Modifiers ---
		CHILLED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("chilled_effect"), -0.15F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
				.addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, VariousStatusEffects.identifier("chilled_effect"), -0.15F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		CIVILISATION
				.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
				.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
				.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("civilisation_effect"), 10.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		HEALTH_REGENERATION
				.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("health_regeneration_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		HEALTH_REGENERATION_AURA
				.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("health_regeneration_aura_effect"), -0.25F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		MANA_REGENERATION
				.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("mana_regeneration_effect"), 2.0F, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		OVERBURDENED
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("overburdened_effect"), -0.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
//        SHOCKED_DAMAGE_INCREASE
//                .addAttributeModifier(OverhauledDamage.DAMAGE_TAKEN_MULTIPLIER, VariousStatusEffects.identifier("shocked_damage_increase_effect"), 0.25, EntityAttributeModifier.Operation.ADD_VALUE)
//        ;
		LIGHT_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("light_load_effect"), 7.0, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		MEDIUM_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("medium_load_effect"), 6.0, EntityAttributeModifier.Operation.ADD_VALUE)
		;
		HEAVY_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("heavy_load_effect"), 5.0, EntityAttributeModifier.Operation.ADD_VALUE)
				.addAttributeModifier(CombatRoll.Attributes.DISTANCE.entry, VariousStatusEffects.identifier("heavy_load_effect"), -1.0, EntityAttributeModifier.Operation.ADD_VALUE)
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("heavy_load_effect"), -0.1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;

		// --- Configuration ---
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

		// --- Registration ---
		VariousStatusEffects.BLEEDING = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("bleeding"), BLEEDING);
		VariousStatusEffects.BURNING = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("burning"), BURNING);
		VariousStatusEffects.CALAMITY = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("calamity"), CALAMITY);
		VariousStatusEffects.CIVILISATION = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("civilisation"), CIVILISATION);
		VariousStatusEffects.CHILLED = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("chilled"), CHILLED);
		VariousStatusEffects.FALL_IMMUNE = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("fall_immune"), FALL_IMMUNE);
		VariousStatusEffects.FROZEN = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("frozen"), FROZEN);
		VariousStatusEffects.HEALTH_REGENERATION = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("health_regeneration"), HEALTH_REGENERATION);
		VariousStatusEffects.HEALTH_REGENERATION_AURA = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("health_regeneration_aura"), HEALTH_REGENERATION_AURA);
		VariousStatusEffects.KEEP_INVENTORY = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("keep_inventory"), KEEP_INVENTORY);
		VariousStatusEffects.LAVA_IMMUNE = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("lava_immune"), LAVA_IMMUNE);
		VariousStatusEffects.NEEDS_TWO_HANDING = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("needs_two_handing"), NEEDS_TWO_HANDING);
		VariousStatusEffects.NO_ATTACK_ITEM = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("no_attack_item"), NO_ATTACK_ITEM);
		VariousStatusEffects.OVERBURDENED = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("overburdened"), OVERBURDENED);
		VariousStatusEffects.POISON = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("poison"), POISON);
		VariousStatusEffects.SHOCKED_INSTANT = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("shocked_instant"), SHOCKED_INSTANT);
		VariousStatusEffects.SHOCKED_DAMAGE_INCREASE = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("shocked_damage_increase"), SHOCKED_DAMAGE_INCREASE);
		VariousStatusEffects.STAGGERED = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("staggered"), STAGGERED);
		VariousStatusEffects.WET = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("wet"), WET);
		VariousStatusEffects.WILDERNESS = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("wilderness"), WILDERNESS);
		VariousStatusEffects.LIGHT_LOAD = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("light_load"), LIGHT_LOAD);
		VariousStatusEffects.MEDIUM_LOAD = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("medium_load"), MEDIUM_LOAD);
		VariousStatusEffects.HEAVY_LOAD = Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("heavy_load"), HEAVY_LOAD);
	}
}
