package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.variousstatuseffects.compat.CombatRollCompat;
import com.github.theredbrain.variousstatuseffects.compat.CombatRollExtensionCompat;
import com.github.theredbrain.variousstatuseffects.compat.HealthRegenerationOverhaulCompat;
import com.github.theredbrain.variousstatuseffects.compat.ManaAttributesCompat;
import com.github.theredbrain.variousstatuseffects.compat.OverhauledDamageCompat;
import com.github.theredbrain.variousstatuseffects.compat.SpellEngineCompat;
import com.github.theredbrain.variousstatuseffects.compat.SpellEngineExtensionCompat;
import com.github.theredbrain.variousstatuseffects.compat.StaminaAttributesCompat;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.ParticleRegistry;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
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
	public static final boolean isOverhauledDamageLoaded = FabricLoader.getInstance().isModLoaded("overhauleddamage");
	public static final boolean isCombatRollExtensionLoaded = FabricLoader.getInstance().isModLoaded("combatrollextension");
	public static final boolean isCombatRollLoaded = FabricLoader.getInstance().isModLoaded("combat_roll");
	public static final boolean isSpellEngineLoaded = FabricLoader.getInstance().isModLoaded("spell_engine");
	public static final boolean isSpellEngineExtensionLoaded = FabricLoader.getInstance().isModLoaded("spellengineextension");

	public static SimpleParticleType BLOOD_DROP;
	public static SimpleParticleType HIT_STUN_PARTICLE;

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
	public static RegistryEntry<StatusEffect> HIT_STUN;
	public static RegistryEntry<StatusEffect> INSTANT_STAMINA_LOSS;
	public static RegistryEntry<StatusEffect> INSTANT_STAGGER_BUILD_UP;

	public static float getCurrentMana(LivingEntity livingEntity) {
		float currentMana = 0.0F;
		if (isManaAttributesLoaded) {
			currentMana = ManaAttributesCompat.getCurrentMana(livingEntity);
		}
		return currentMana;
	}

	public static void addStamina(LivingEntity livingEntity, float amount) {
		if (isStaminaAttributesLoaded) {
			StaminaAttributesCompat.addStamina(livingEntity, amount);
		}
	}

	public static void addStaggerBuildUp(LivingEntity livingEntity, float amount) {
		if (isOverhauledDamageLoaded) {
			OverhauledDamageCompat.addStaggerBuildUp(livingEntity, amount);
		}
	}

	public static void addModdedAttributesToEffects() {
		if (isCombatRollLoaded && SERVER_CONFIG.enable_combat_roll_compatibility.get()) {
			CombatRollCompat.addAttributes();
		}
		if (isCombatRollExtensionLoaded && SERVER_CONFIG.enable_combat_roll_extension_compatibility.get()) {
			CombatRollExtensionCompat.addAttributes();
		}
		if (isHealthRegenerationOverhaulLoaded && SERVER_CONFIG.enable_health_regeneration_overhaul_compatibility.get()) {
			HealthRegenerationOverhaulCompat.addAttributes();
		}
		if (isManaAttributesLoaded && SERVER_CONFIG.enable_mana_attributes_compatibility.get()) {
			ManaAttributesCompat.addAttributes();
		}
		if (isOverhauledDamageLoaded && SERVER_CONFIG.enable_overhauled_damage_compatibility.get()) {
			OverhauledDamageCompat.addAttributes();
		}
		if (isStaminaAttributesLoaded && SERVER_CONFIG.enable_stamina_attributes_compatibility.get()) {
			StaminaAttributesCompat.addAttributes();
		}
		if (isSpellEngineLoaded && SERVER_CONFIG.enable_spell_engine_compatibility.get()) {
			SpellEngineCompat.addAttributes();
		}
	}

	public static void configureEffects() {
		if (isSpellEngineLoaded && SERVER_CONFIG.enable_spell_engine_compatibility.get()) {
			SpellEngineCompat.configureEffects();
		}
		if (isSpellEngineExtensionLoaded && SERVER_CONFIG.enable_spell_engine_extension_compatibility.get()) {
			SpellEngineExtensionCompat.configureEffects();
		}
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Status effects for everyone!");
		SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new, RegisterType.BOTH);
		ParticleRegistry.registerParticles();
		StatusEffectsRegistry.registerEffects();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}