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
	public static ServerConfig SERVER_CONFIG = ConfigApiJava.registerAndLoadConfig(ServerConfig::new, RegisterType.BOTH);

	public static final StatusEffect BLEEDING = new BleedingStatusEffect();
	public static final StatusEffect BURNING = new BurningStatusEffect();
	public static final StatusEffect CALAMITY = new NeutralStatusEffect();
	public static final StatusEffect CHILLED = new HarmfulStatusEffect();
	public static final StatusEffect CIVILISATION = new BeneficialStatusEffect();
	public static final StatusEffect FALL_IMMUNE = new BeneficialStatusEffect();
	public static final StatusEffect FROZEN = new HarmfulStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION = new BeneficialStatusEffect();
	public static final StatusEffect HEALTH_REGENERATION_AURA = new AuraStatusEffect(true, true, VariousStatusEffects.HEALTH_REGENERATION, 100, 0, true, false, true);
	public static final StatusEffect KEEP_INVENTORY = new BeneficialStatusEffect();
	public static final StatusEffect LAVA_IMMUNE = new BeneficialStatusEffect();
	public static final StatusEffect MANA_REGENERATION = new BeneficialStatusEffect();
	public static final StatusEffect NEEDS_TWO_HANDING = new NeutralStatusEffect();
	public static final StatusEffect NO_ATTACK_ITEM = new NeutralStatusEffect();
	public static final StatusEffect OVERBURDENED = new HarmfulStatusEffect();
	public static final StatusEffect LIGHT_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect MEDIUM_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect HEAVY_LOAD = new HarmfulStatusEffect();
	public static final StatusEffect POISON = new CustomPoisonStatusEffect();
	public static final StatusEffect SHOCKED_INSTANT = new ShockedInstantStatusEffect();
	public static final StatusEffect SHOCKED_DAMAGE_INCREASE = new HarmfulStatusEffect();
	public static final StatusEffect STAGGERED = new HarmfulStatusEffect();
	public static final StatusEffect WET = new HarmfulStatusEffect();
	public static final StatusEffect WILDERNESS = new HarmfulStatusEffect();

	@Override
	public void onInitialize() {
		LOGGER.info("Status effects for everyone!");
		StatusEffectsRegistry.registerEffects();
	}

	public static Identifier identifier(String path) {
		return new Identifier(MOD_ID, path);
	}
}