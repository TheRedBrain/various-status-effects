package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.manaattributes.ManaAttributes;
import com.github.theredbrain.manaattributes.entity.ManaUsingEntity;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class ManaAttributesCompat {

	public static float getCurrentMana(LivingEntity livingEntity) {
		return ((ManaUsingEntity) livingEntity).manaattributes$getMana();
	}

	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.CIVILISATION
				.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), serverConfig.civilisationSection.additional_mana_regeneration.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
		StatusEffectsRegistry.HEALTH_REGENERATION_AURA
				.addAttributeModifier(ManaAttributes.MAX_MANA, VariousStatusEffects.identifier("effect.health_regeneration_aura_effect"), serverConfig.healthRegenerationAuraSection.max_mana_total_multiplier.get(), EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
		;
		StatusEffectsRegistry.MANA_REGENERATION
				.addAttributeModifier(ManaAttributes.MANA_REGENERATION, VariousStatusEffects.identifier("effect.mana_regeneration_effect"), serverConfig.manaRegenerationSection.additional_mana_regeneration.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}
}
