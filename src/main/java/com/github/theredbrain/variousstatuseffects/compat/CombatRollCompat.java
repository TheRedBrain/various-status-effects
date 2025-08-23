package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.combat_roll.api.CombatRoll;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class CombatRollCompat {
	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.HEAVY_LOAD
				.addAttributeModifier(CombatRoll.Attributes.DISTANCE.entry, VariousStatusEffects.identifier("effect.heavy_load_effect"), serverConfig.heavyLoadSection.additional_roll_distance.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
		StatusEffectsRegistry.HIT_STUN
				.addAttributeModifier(CombatRoll.Attributes.DISTANCE.entry, VariousStatusEffects.identifier("effect.hit_stun_effect"), serverConfig.hitStunSection.additional_roll_distance.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}
}
