package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import com.github.theredbrain.variousstatuseffects.spell_engine.ExtendedEntityActionsAllowedSemanticType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.spell_engine.api.effect.ActionImpairing;
import net.spell_engine.api.effect.EntityActionsAllowed;
import net.spell_engine.api.effect.Synchronized;
import net.spell_engine.api.entity.SpellEngineAttributes;

public class SpellEngineCompat {
	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
		StatusEffectsRegistry.SHOCKED_DAMAGE_INCREASE
				.addAttributeModifier(SpellEngineAttributes.DAMAGE_TAKEN.entry, VariousStatusEffects.identifier("effect.shocked_damage_increase_effect"), serverConfig.shockedDamageIncreaseSection.additional_damage_taken.get(), EntityAttributeModifier.Operation.ADD_VALUE)
		;
	}

	public static void configureEffects() {
		ActionImpairing.configure(StatusEffectsRegistry.NO_ATTACK_ITEM, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, true, true), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NO_ATTACK_ITEM));
		ActionImpairing.configure(StatusEffectsRegistry.NEEDS_TWO_HANDING, new EntityActionsAllowed(true, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(true), ExtendedEntityActionsAllowedSemanticType.NEEDS_TWO_HANDING));
		ActionImpairing.configure(StatusEffectsRegistry.STAGGERED, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.STAGGERED));
		ActionImpairing.configure(StatusEffectsRegistry.OVERBURDENED, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(true, true, true), new EntityActionsAllowed.MobsAllowed(true), EntityActionsAllowed.SemanticType.NONE));
		ActionImpairing.configure(StatusEffectsRegistry.FROZEN, new EntityActionsAllowed(false, false, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), ExtendedEntityActionsAllowedSemanticType.FROZEN));
		ActionImpairing.configure(StatusEffectsRegistry.HIT_STUN, new EntityActionsAllowed(false, true, new EntityActionsAllowed.PlayersAllowed(false, false, false), new EntityActionsAllowed.MobsAllowed(false), EntityActionsAllowed.SemanticType.STUN));

		Synchronized.configure(StatusEffectsRegistry.BLEEDING, true);
		Synchronized.configure(StatusEffectsRegistry.BURNING, true);
		Synchronized.configure(StatusEffectsRegistry.CHILLED, true);
		Synchronized.configure(StatusEffectsRegistry.FROZEN, true);
		Synchronized.configure(StatusEffectsRegistry.HEALTH_REGENERATION_AURA, true);
		Synchronized.configure(StatusEffectsRegistry.STAGGERED, true);
		Synchronized.configure(StatusEffectsRegistry.WET, true);
		Synchronized.configure(StatusEffectsRegistry.HIT_STUN, true);
	}
}
