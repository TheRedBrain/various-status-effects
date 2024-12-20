package com.github.theredbrain.variousstatuseffects.spell_engine;

import net.spell_engine.api.effect.EntityActionsAllowed;

public class ExtendedEntityActionsAllowedSemanticType {
	public static EntityActionsAllowed.SemanticType FROZEN = EntityActionsAllowed.SemanticType.valueOf("FROZEN");
	public static EntityActionsAllowed.SemanticType NEEDS_TWO_HANDING = EntityActionsAllowed.SemanticType.valueOf("NEEDS_TWO_HANDING");
	public static EntityActionsAllowed.SemanticType NO_ATTACK_ITEM = EntityActionsAllowed.SemanticType.valueOf("NO_ATTACK_ITEM");
	public static EntityActionsAllowed.SemanticType STAGGERED = EntityActionsAllowed.SemanticType.valueOf("STAGGERED");
}