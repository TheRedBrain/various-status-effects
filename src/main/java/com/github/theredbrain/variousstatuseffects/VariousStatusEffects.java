package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.effect.AuraStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BeneficialStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BleedingStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.BurningStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.CustomPoisonStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.HarmfulStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.NeutralStatusEffect;
import com.github.theredbrain.variousstatuseffects.effect.ShockedInstantStatusEffect;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VariousStatusEffects implements ModInitializer {
	public static final String MOD_ID = "variousstatuseffects";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ServerConfig SERVER_CONFIG;


	public static StatusEffect BLEEDING;
	public static StatusEffect BURNING;
	public static StatusEffect CALAMITY;
	public static StatusEffect CHILLED;
	public static StatusEffect CIVILISATION;
	public static StatusEffect FALL_IMMUNE;
	public static StatusEffect FROZEN;
	public static StatusEffect HEALTH_REGENERATION;
	public static StatusEffect HEALTH_REGENERATION_AURA;
	public static StatusEffect KEEP_INVENTORY;
	public static StatusEffect LAVA_IMMUNE;
	public static StatusEffect MANA_REGENERATION;
	public static StatusEffect NEEDS_TWO_HANDING;
	public static StatusEffect NO_ATTACK_ITEM;
	public static StatusEffect OVERBURDENED;
	public static StatusEffect LIGHT_LOAD;
	public static StatusEffect MEDIUM_LOAD;
	public static StatusEffect HEAVY_LOAD;
	public static StatusEffect POISON;
	public static StatusEffect SHOCKED_INSTANT;
	public static StatusEffect SHOCKED_DAMAGE_INCREASE;
	public static StatusEffect STAGGERED;
	public static StatusEffect WET;
	public static StatusEffect WILDERNESS;
	public static StatusEffect HIT_STUN;

	@Override
	public void onInitialize() {
		LOGGER.info("Status effects for everyone!");
		SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new, RegisterType.BOTH);
		StatusEffectsRegistry.registerEffects();
	}

	public static Identifier identifier(String path) {
		return new Identifier(MOD_ID, path);
	}
}