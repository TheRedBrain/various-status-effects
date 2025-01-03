package com.github.theredbrain.variousstatuseffects.registry;

import com.github.theredbrain.combatrollextension.CombatRollExtension;
import com.github.theredbrain.healthregenerationoverhaul.HealthRegenerationOverhaul;
import com.github.theredbrain.manaattributes.ManaAttributes;
import com.github.theredbrain.overhauleddamage.OverhauledDamage;
import com.github.theredbrain.staminaattributes.StaminaAttributes;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.spell_engine.ExtendedEntityActionsAllowedSemanticType;
import net.combatroll.api.EntityAttributes_CombatRoll;
import net.combatroll.internals.RollManager;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.spell_engine.api.effect.ActionImpairing;
import net.spell_engine.api.effect.EntityActionsAllowed;
import net.spell_engine.api.effect.Synchronized;

public class StatusEffectsRegistry {

    private static final String CIVILISATION_EFFECT_MODIFIER_UUID = "fd44f9cd-ce93-4a85-834e-a4eebc838050";
    private static final String CHILLED_EFFECT_MODIFIER_UUID = "47112e1e-823b-434f-85f4-dba55bf335e8";
    private static final String HEALTH_REGENERATION_EFFECT_MODIFIER_UUID = "dba456b2-a30a-45a4-b7dc-4166e2798ca5";
    private static final String HEALTH_REGENERATION_AURA_EFFECT_MODIFIER_UUID = "07b833f2-3160-41a2-8632-e4df6203ff8d";
    private static final String MANA_REGENERATION_EFFECT_MODIFIER_UUID = "dba456b2-a30a-45a4-b7dc-4166e2798ca5";
    private static final String OVERBURDENED_EFFECT_MODIFIER_UUID = "5dfb38b6-c7a1-4e64-8df0-9c9a951367d7";
    private static final String LIGHT_LOAD_EFFECT_MODIFIER_UUID = "f7744d2e-a275-4f6f-b723-0de447993ca8";
    private static final String MEDIUM_LOAD_EFFECT_MODIFIER_UUID = "473e8074-041c-4553-851b-29bc8e459cc4";
    private static final String HEAVY_LOAD_EFFECT_MODIFIER_UUID = "63b79b82-e453-44c9-81f0-d3d75e17a026";

    public static void registerEffects() {
        // --- Attribute Modifiers ---
        VariousStatusEffects.CHILLED
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, CHILLED_EFFECT_MODIFIER_UUID, -0.15F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
                .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_SPEED, CHILLED_EFFECT_MODIFIER_UUID, -0.15F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
        ;
        VariousStatusEffects.CIVILISATION
                .addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, CIVILISATION_EFFECT_MODIFIER_UUID, 10.0F, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(ManaAttributes.MANA_REGENERATION, CIVILISATION_EFFECT_MODIFIER_UUID, 10.0F, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, CIVILISATION_EFFECT_MODIFIER_UUID, 10.0F, EntityAttributeModifier.Operation.ADDITION)
        ;
        VariousStatusEffects.HEALTH_REGENERATION
                .addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, HEALTH_REGENERATION_EFFECT_MODIFIER_UUID, 2.0F, EntityAttributeModifier.Operation.ADDITION)
        ;
        VariousStatusEffects.HEALTH_REGENERATION_AURA
                .addAttributeModifier(ManaAttributes.MAX_MANA, HEALTH_REGENERATION_AURA_EFFECT_MODIFIER_UUID, -0.25F, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
        ;
        VariousStatusEffects.MANA_REGENERATION
                .addAttributeModifier(ManaAttributes.MANA_REGENERATION, MANA_REGENERATION_EFFECT_MODIFIER_UUID, 2.0F, EntityAttributeModifier.Operation.ADDITION)
        ;
        VariousStatusEffects.OVERBURDENED
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, OVERBURDENED_EFFECT_MODIFIER_UUID, -0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
        ;
//        VariousStatusEffects.SHOCKED_DAMAGE_INCREASE
//                .addAttributeModifier(OverhauledDamage.DAMAGE_TAKEN_MULTIPLIER, SHOCKED_DAMAGE_INCREASE_EFFECT_MODIFIER_UUID, 0.25, EntityAttributeModifier.Operation.ADDITION)
//        ;
        VariousStatusEffects.LIGHT_LOAD
                .addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, LIGHT_LOAD_EFFECT_MODIFIER_UUID, 7.0, EntityAttributeModifier.Operation.ADDITION)
        ;
        VariousStatusEffects.MEDIUM_LOAD
                .addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, MEDIUM_LOAD_EFFECT_MODIFIER_UUID, 6.0, EntityAttributeModifier.Operation.ADDITION)
        ;
        VariousStatusEffects.HEAVY_LOAD
                .addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, HEAVY_LOAD_EFFECT_MODIFIER_UUID, 5.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes_CombatRoll.DISTANCE, HEAVY_LOAD_EFFECT_MODIFIER_UUID, -1.0, EntityAttributeModifier.Operation.ADDITION)
                .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, HEAVY_LOAD_EFFECT_MODIFIER_UUID, -0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL)
        ;

        // --- Configuration ---
        ActionImpairing.configure(VariousStatusEffects.NO_ATTACK_ITEM, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, true, true), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NO_ATTACK_ITEM));
        ActionImpairing.configure(VariousStatusEffects.NEEDS_TWO_HANDING, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NEEDS_TWO_HANDING));
        ActionImpairing.configure(VariousStatusEffects.STAGGERED, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.STAGGERED));
        ActionImpairing.configure(VariousStatusEffects.OVERBURDENED, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(true, true, true), new EntityActionsAllowed.MobsAllowed(true), EntityActionsAllowed.SemanticType.NONE));
        ActionImpairing.configure(VariousStatusEffects.FROZEN, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.FROZEN));

        Synchronized.configure(VariousStatusEffects.BURNING, true);
        Synchronized.configure(VariousStatusEffects.CHILLED, true);
        Synchronized.configure(VariousStatusEffects.FROZEN, true);
        Synchronized.configure(VariousStatusEffects.HEALTH_REGENERATION_AURA, true);
        Synchronized.configure(VariousStatusEffects.STAGGERED, true);
        Synchronized.configure(VariousStatusEffects.WET, true);

        // --- Registration ---
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("bleeding"), VariousStatusEffects.BLEEDING);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("burning"), VariousStatusEffects.BURNING);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("calamity"), VariousStatusEffects.CALAMITY);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("civilisation"), VariousStatusEffects.CIVILISATION);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("chilled"), VariousStatusEffects.CHILLED);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("fall_immune"), VariousStatusEffects.FALL_IMMUNE);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("frozen"), VariousStatusEffects.FROZEN);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("health_regeneration"), VariousStatusEffects.HEALTH_REGENERATION);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("health_regeneration_aura"), VariousStatusEffects.HEALTH_REGENERATION_AURA);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("keep_inventory"), VariousStatusEffects.KEEP_INVENTORY);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("lava_immune"), VariousStatusEffects.LAVA_IMMUNE);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("needs_two_handing"), VariousStatusEffects.NEEDS_TWO_HANDING);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("no_attack_item"), VariousStatusEffects.NO_ATTACK_ITEM);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("overburdened"), VariousStatusEffects.OVERBURDENED);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("poison"), VariousStatusEffects.POISON);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("shocked_instant"), VariousStatusEffects.SHOCKED_INSTANT);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("shocked_damage_increase"), VariousStatusEffects.SHOCKED_DAMAGE_INCREASE);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("staggered"), VariousStatusEffects.STAGGERED);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("wet"), VariousStatusEffects.WET);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("wilderness"), VariousStatusEffects.WILDERNESS);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("light_load"), VariousStatusEffects.LIGHT_LOAD);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("medium_load"), VariousStatusEffects.MEDIUM_LOAD);
        Registry.register(Registries.STATUS_EFFECT, VariousStatusEffects.identifier("heavy_load"), VariousStatusEffects.HEAVY_LOAD);
    }
}
