package com.github.theredbrain.variousstatuseffects.config;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedColor;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedDouble;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt;

@RequiresAction(action = Action.RESTART)
public class ServerConfig extends Config {

	public ServerConfig() {
		super(VariousStatusEffects.identifier("server"));
	}

	public ValidatedBoolean enable_combat_roll_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_combat_roll_extension_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_health_regeneration_overhaul_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_mana_attributes_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_overhauled_damage_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_stamina_attributes_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_spell_engine_compatibility = new ValidatedBoolean(true);
	public ValidatedBoolean enable_spell_engine_extension_compatibility = new ValidatedBoolean(true);

	public BleedingSection bleedingSection = new BleedingSection();

	public static class BleedingSection extends ConfigSection {
		public ValidatedInt tick_update_threshold = new ValidatedInt(20);
		public ValidatedBoolean moving_doubles_damage = new ValidatedBoolean(true);
		public ValidatedFloat max_health_multiplier = new ValidatedFloat(0.1F);
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
	}

	public BurningSection burningSection = new BurningSection();

	public static class BurningSection extends ConfigSection {
		public ValidatedInt tick_update_threshold = new ValidatedInt(50);
		public ValidatedFloat damage_per_tick = new ValidatedFloat(2.0F);
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
	}

	public ChilledSection chilledSection = new ChilledSection();

	public static class ChilledSection extends ConfigSection {
		public ValidatedDouble movement_speed_total_multiplier = new ValidatedDouble(-0.15);
		public ValidatedDouble attack_speed_total_multiplier = new ValidatedDouble(-0.15);
	}

	public OverburdenedSection overburdenedSection = new OverburdenedSection();

	public static class OverburdenedSection extends ConfigSection {
		public ValidatedDouble movement_speed_total_multiplier = new ValidatedDouble(-0.25);
	}

	public HealthRegenerationSection healthRegenerationSection = new HealthRegenerationSection();

	public static class HealthRegenerationSection extends ConfigSection {
		public ValidatedDouble additional_health_regeneration = new ValidatedDouble(2.0);
	}

	public HealthRegenerationAuraSection healthRegenerationAuraSection = new HealthRegenerationAuraSection();

	public static class HealthRegenerationAuraSection extends ConfigSection {
		public ValidatedDouble max_mana_total_multiplier = new ValidatedDouble(-0.25);
	}

	public ManaRegenerationSection manaRegenerationSection = new ManaRegenerationSection();

	public static class ManaRegenerationSection extends ConfigSection {
		public ValidatedDouble additional_mana_regeneration = new ValidatedDouble(2.0);
	}

	public PoisonSection poisonSection = new PoisonSection();

	public static class PoisonSection extends ConfigSection {
		public ValidatedInt tick_update_threshold = new ValidatedInt(40);
		public ValidatedFloat amplifier_multiplier = new ValidatedFloat(1.0F);
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
	}

	public ShockedInstantSection shockedInstantSection = new ShockedInstantSection();

	public static class ShockedInstantSection extends ConfigSection {
		public ValidatedFloat damage = new ValidatedFloat(10.0f);
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
	}

	public ShockedDamageIncreaseSection shockedDamageIncreaseSection = new ShockedDamageIncreaseSection();

	public static class ShockedDamageIncreaseSection extends ConfigSection {
		public ValidatedDouble additional_damage_taken = new ValidatedDouble(25.0);
	}

	public LightLoadSection lightLoadSection = new LightLoadSection();

	public static class LightLoadSection extends ConfigSection {
		public ValidatedDouble additional_roll_invulnerability_frames = new ValidatedDouble(7.0);
	}

	public MediumLoadSection mediumLoadSection = new MediumLoadSection();

	public static class MediumLoadSection extends ConfigSection {
		public ValidatedDouble additional_roll_invulnerability_frames = new ValidatedDouble(6.0);
	}

	public HeavyLoadSection heavyLoadSection = new HeavyLoadSection();

	public static class HeavyLoadSection extends ConfigSection {
		public ValidatedDouble additional_roll_invulnerability_frames = new ValidatedDouble(5.0);
		public ValidatedDouble additional_roll_distance = new ValidatedDouble(-1.0);
		public ValidatedDouble movement_speed_total_multiplier = new ValidatedDouble(-0.2);
	}

	public HitStunSection hitStunSection = new HitStunSection();

	public static class HitStunSection extends ConfigSection {
		public ValidatedDouble additional_roll_distance = new ValidatedDouble(0.0);
		public ValidatedDouble movement_speed_total_multiplier = new ValidatedDouble(-0.7);
		public ValidatedDouble attack_speed_total_multiplier = new ValidatedDouble(-0.1);
	}

	public InstantStaminaLossSection instantStaminaLossSection = new InstantStaminaLossSection();

	public static class InstantStaminaLossSection extends ConfigSection {
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
		public ValidatedFloat loss_per_level = new ValidatedFloat(1);
	}

	public InstantStaggerBuildUpSection instantStaggerBuildUpSection = new InstantStaggerBuildUpSection();

	public static class InstantStaggerBuildUpSection extends ConfigSection {
		public ValidatedColor effect_color = new ValidatedColor(1, 1, 1);
		public ValidatedFloat build_up_per_level = new ValidatedFloat(1);
	}

	public CivilisationSection civilisationSection = new CivilisationSection();

	public static class CivilisationSection extends ConfigSection {
		public ValidatedDouble additional_health_regeneration = new ValidatedDouble(10.0);
		public ValidatedDouble additional_mana_regeneration = new ValidatedDouble(10.0);
		public ValidatedDouble additional_stamina_regeneration = new ValidatedDouble(10.0);
	}

}
