package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VariousStatusEffects implements ModInitializer {
	public static final String MOD_ID = "variousstatuseffects";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static ServerConfig SERVER_CONFIG;

	public static final boolean isManaAttributesLoaded = FabricLoader.getInstance().isModLoaded("manaattributes");
	public static final boolean isStaminaAttributesLoaded = FabricLoader.getInstance().isModLoaded("staminaattributes");
	public static final boolean isHealthRegenerationOverhaulLoaded = FabricLoader.getInstance().isModLoaded("healthregenerationoverhaul");
	public static final boolean isFoodOverhaulLoaded = FabricLoader.getInstance().isModLoaded("foodoverhaul");
	public static final boolean isOverhauledDamageLoaded = FabricLoader.getInstance().isModLoaded("overhauleddamage");
	public static final boolean isCombatRollExtensionLoaded = FabricLoader.getInstance().isModLoaded("combatrollextension");
	public static final boolean isCombatRollLoaded = FabricLoader.getInstance().isModLoaded("combat_roll");
	public static final boolean isSpellEngineLoaded = FabricLoader.getInstance().isModLoaded("spell_engine");

	// region food effects
	public static RegistryEntry<StatusEffect> APPLE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BAKED_POTATO_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BEEF_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BEETROOT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BEETROOT_SOUP_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BREAD_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> BROWN_MUSHROOM_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> CAKE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> CARROT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> CHICKEN_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> CHORUS_FRUIT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COCOA_BEANS_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COD_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_BEEF_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_CHICKEN_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_COD_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_MUTTON_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_PORKCHOP_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_RABBIT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKED_SALMON_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> COOKIE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> DRIED_KELP_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> ENCHANTED_GOLDEN_APPLE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> FERMENTED_SPIDER_EYE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> GLOW_BERRIES_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> GOLDEN_APPLE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> GOLDEN_CARROT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> HONEY_BOTTLE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> MELON_SLICE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> MUSHROOM_STEW_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> MUTTON_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> POISONOUS_POTATO_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> PORKCHOP_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> POTATO_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> PUFFERFISH_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> PUMPKIN_PIE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> RABBIT_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> RABBIT_STEW_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> RED_MUSHROOM_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> ROTTEN_FLESH_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> SALMON_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> SPIDER_EYE_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> SUGAR_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> SUSPICIOUS_STEW_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> SWEET_BERRIES_FOOD_EFFECT;
	public static RegistryEntry<StatusEffect> TROPICAL_FISH_FOOD_EFFECT;
	// endregion food effects

	// region other effects
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
	// endregion other effects

	@Override
	public void onInitialize() {
		LOGGER.info("Status effects for everyone!");
		SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new, RegisterType.BOTH);
		StatusEffectsRegistry.registerEffects();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}