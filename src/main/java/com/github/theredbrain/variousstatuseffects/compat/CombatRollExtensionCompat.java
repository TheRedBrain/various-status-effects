package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.combatrollextension.CombatRollExtension;
import com.github.theredbrain.staminaattributes.StaminaAttributes;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.combat_roll.api.CombatRoll;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class CombatRollExtensionCompat {
	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.LIGHT_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.light_load_effect"), serverConfig.lightLoadSection.additional_roll_invulnerability_frames.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
		StatusEffectsRegistry.MEDIUM_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.medium_load_effect"), serverConfig.mediumLoadSection.additional_roll_invulnerability_frames.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
		StatusEffectsRegistry.HEAVY_LOAD
				.addAttributeModifier(CombatRollExtension.ROLL_INVULNERABLE_TICKS, VariousStatusEffects.identifier("effect.heavy_load_effect"), serverConfig.heavyLoadSection.additional_roll_invulnerability_frames.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}
}
