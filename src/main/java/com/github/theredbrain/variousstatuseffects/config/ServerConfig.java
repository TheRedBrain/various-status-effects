package com.github.theredbrain.variousstatuseffects.config;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedBoolean;
import me.fzzyhmstrs.fzzy_config.validation.misc.ValidatedColor;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt;

@RequiresAction(action = Action.RESTART)
public class ServerConfig extends Config {

	public ServerConfig() {
		super(VariousStatusEffects.identifier("server"));
	}

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

}
