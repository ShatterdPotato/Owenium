package shatterdpotato.owenium.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent OWENIUM_APPLE = new FoodComponent.Builder().hunger(4).saturationModifier(.25f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60, 2),1f).build();
}
