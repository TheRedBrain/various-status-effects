package com.github.theredbrain.variousstatuseffects;

import com.github.theredbrain.manaattributes.entity.ManaUsingEntity;
import com.github.theredbrain.overhauleddamage.entity.DuckLivingEntityMixin;
import com.github.theredbrain.staminaattributes.entity.StaminaUsingEntity;
import com.github.theredbrain.overhauleddamage.entity.DuckLivingEntityMixin;
import com.github.theredbrain.staminaattributes.entity.StaminaUsingEntity;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import com.github.theredbrain.variousstatuseffects.registry.ParticleRegistry;
import com.github.theredbrain.variousstatuseffects.registry.StatusEffectsRegistry;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.api.RegisterType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.spell_engine.api.effect.CustomParticleStatusEffect;
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
			currentMana = ((ManaUsingEntity) livingEntity).manaattributes$getMana();
		}
		return currentMana;
	}

	public static void addStamina(LivingEntity livingEntity, float amount) {
		if (isStaminaAttributesLoaded) {
			((StaminaUsingEntity) livingEntity).staminaattributes$addStamina(amount);
		}
	}

	public static void addStaggerBuildUp(LivingEntity livingEntity, float amount) {
		if (isOverhauledDamageLoaded) {
			((DuckLivingEntityMixin) livingEntity).overhauleddamage$addStaggerBuildUp(amount);
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