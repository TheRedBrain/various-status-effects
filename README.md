# Various Status Effects

This mod serves as a library for status effects.

## How are the status effects applied?
You need to install other mods to use these effects during normal gameplay.

## Why do status effects need their own mod?
- easier maintenance
- more control and customizability for mod pack authors
- fewer dependencies for the other mods
- implementing new status effect types like auras only in one project
- future proofing for data-driven status effects

## List of all status effects

### Gameplay effects
All vanilla effects fall under this category. They directly impact the entity they are applied to.
- bleeding: inflicts damage with the bleeding damage type every second. The damage is 10% of <generic.max_health> and it's doubled when the entity is moving
- burning: inflicts 2 damage with the burning damage type every 2.5 seconds
- chilled: reduces the "generic.movement_speed" and "generic.attack_speed" attributes by 15% each
- civilization: increases the "generic.health_regeneration", "generic.mana_regeneration" and "generic.stamina_regeneration" attributes by 10 each
- frozen: prevents moving, jumping, attacking, using items, spell casting and disables mob AI
- health regeneration: increases the "generic.health_regeneration" attribute by 2
- mana regeneration: increases the "generic.mana_regeneration" attribute by 2
- overburdened: reduces the "generic.movement_speed" attribute by 25%, also prevents jumping
- poison: inflicts <amplifier + 1> damage with the poison damage type every 2 seconds
- shocked: instant effect that inflicts 10 damage with the shocked damage type
- staggered: prevents moving, jumping, attacking, using items, spell casting and disables mob AI
- some effects don't do anything when they are applied, but other mods can check if they are applied to an entity and do stuff based on that
  - calamity
  - fall immune
  - lava immune
  - wet
  - wilderness

#### Aura effects 
These are a new type of status effects. An entity which has an aura effect, applies another status effect to entities around it (like a mobile beacon) and optionally to itself. Aura effects may be removed, if mana is not above 0.
- health regeneration aura, applies the "health regeneration" effect to nearby entities (including the one having the aura) and reduces the "generic.max_mana" attribute by 25%

### Utility effects
They are designed to be not directly visible to the player, but provide functionality to other features. Since they are supposed to be working in the background, it is recommended to apply them with the "showParticles" and "showIcon" set to false.
- keep_inventory
- needs_two_handing: prevents attacking, using items and spell casting
- no_attack_item: prevents attacking
