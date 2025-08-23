package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.healthregenerationoverhaul.HealthRegenerationOverhaul;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class HealthRegenerationOverhaulCompat {
	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.HEALTH_REGENERATION
				.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.health_regeneration_effect"), serverConfig.healthRegenerationSection.additional_health_regeneration.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
		StatusEffectsRegistry.CIVILISATION
				.addAttributeModifier(HealthRegenerationOverhaul.HEALTH_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), serverConfig.civilisationSection.additional_health_regeneration.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}
}
