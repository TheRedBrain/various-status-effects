package com.github.theredbrain.variousstatuseffects.compat;

import com.github.theredbrain.variousstatuseffects.VariousStatusEffects;
import com.github.theredbrain.variousstatuseffects.config.ServerConfig;
import net.minecraft.entity.LivingEntity;

public class OverhauledDamageCompat {

	public static void addStaggerBuildUp(LivingEntity livingEntity, float amount) {
//			((DuckLivingEntityMixin) livingEntity).overhauleddamage$addStaggerBuildUp(amount);
	}

	public static void addAttributes() {
		ServerConfig serverConfig = VariousStatusEffects.SERVER_CONFIG;
	}
}
