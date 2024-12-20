package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VariousStatusEffects implements ModInitializer {
	public static final String MOD_ID = "variousstatuseffects";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ServerConfig SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new, RegisterType.BOTH);

	public static RegistryEntry<StatusEffect> BLEEDING;
	public static RegistryEntry<StatusEffect> BURNING;
	public static RegistryEntry<StatusEffect> CALAMITY;
	public static RegistryEntry<StatusEffect> CHILLED;
	public static RegistryEntry<StatusEffect> CIVILISATION;
	public static RegistryEntry<StatusEffect> FALL_IMMUNE;
	public static RegistryEntry<StatusEffect> FROZEN;
	public static RegistryEntry<StatusEffect> HEALTH_REGENERATION;
	public static RegistryEntry<StatusEffect> HEALTH_REGENERATION_AURA;
	public static RegistryEntry<StatusEffect> KEEP_INVENTORY;
	public static RegistryEntry<StatusEffect> LAVA_IMMUNE;
	public static RegistryEntry<StatusEffect> MANA_REGENERATION;
	public static RegistryEntry<StatusEffect> NEEDS_TWO_HANDING;
	public static RegistryEntry<StatusEffect> NO_ATTACK_ITEM;
	public static RegistryEntry<StatusEffect> OVERBURDENED;
	public static RegistryEntry<StatusEffect> LIGHT_LOAD;
	public static RegistryEntry<StatusEffect> MEDIUM_LOAD;
	public static RegistryEntry<StatusEffect> HEAVY_LOAD;
	public static RegistryEntry<StatusEffect> POISON;
	public static RegistryEntry<StatusEffect> SHOCKED_INSTANT;
	public static RegistryEntry<StatusEffect> SHOCKED_DAMAGE_INCREASE;
	public static RegistryEntry<StatusEffect> STAGGERED;
	public static RegistryEntry<StatusEffect> WET;
	public static RegistryEntry<StatusEffect> WILDERNESS;

	@Override
	public void onInitialize() {
		LOGGER.info("Status effects for everyone!");
		StatusEffectsRegistry.registerEffects();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}