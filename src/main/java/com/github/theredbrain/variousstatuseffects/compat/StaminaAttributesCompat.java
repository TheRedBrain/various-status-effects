package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.staminaattributes.StaminaAttributes;
import com.github.theredbrain.staminaattributes.entity.StaminaUsingEntity;
import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;

public class StaminaAttributesCompat {

	public static void addStamina(LivingEntity livingEntity, float amount) {
		((StaminaUsingEntity) livingEntity).staminaattributes$addStamina(amount);
	}

	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.CIVILISATION
				.addAttributeModifier(StaminaAttributes.STAMINA_REGENERATION, VariousStatusEffects.identifier("effect.civilisation_effect"), serverConfig.civilisationSection.additional_stamina_regeneration.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}
}
