package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.combatrollextension.CombatRollExtension;
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
	private static final StatusEffect HIT_STUN = new HarmfulStatusEffect();
	// endregion

    public static void registerEffects() {
        // --- Attribute Modifiers ---
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
        HIT_STUN
				.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, VariousStatusEffects.identifier("effect.hit_stun_effect"), -0.25, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		// endregion other effects

		// --- Configuration ---
		if (VariousStatusEffects.isSpellEngineLoaded) {
			ActionImpairing.configure(NO_ATTACK_ITEM, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, true, true), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NO_ATTACK_ITEM));
			ActionImpairing.configure(NEEDS_TWO_HANDING, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NEEDS_TWO_HANDING));
			ActionImpairing.configure(STAGGERED, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.STAGGERED));
			ActionImpairing.configure(OVERBURDENED, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(true, true, true), new EntityActionsAllowed.MobsAllowed(true), EntityActionsAllowed.SemanticType.NONE));
			ActionImpairing.configure(FROZEN, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.FROZEN));
            ActionImpairing.configure(HIT_STUN, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), EntityActionsAllowed.SemanticType.STUN));

			Synchronized.configure(BURNING, true);
			Synchronized.configure(CHILLED, true);
			Synchronized.configure(FROZEN, true);
			Synchronized.configure(HEALTH_REGENERATION_AURA, true);
			Synchronized.configure(STAGGERED, true);
			Synchronized.configure(WET, true);
            Synchronized.configure(HIT_STUN, true);
		}

        // --- Registration ---
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
        Registry.register("hit_stun", HIT_STUN);
    }

    private static RegistryEntry<StatusEffect> register(String identifierString, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, VariousStatusEffects.identifier(identifierString), statusEffect);
    }
}
