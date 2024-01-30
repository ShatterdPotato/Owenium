package shatterdpotato.owenium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import shatterdpotato.owenium.Owenium;
import shatterdpotato.owenium.item.custom.OweniumDetectorItem;

public class ModItems {
   public static final Item OWENIUM = registerItem("owenium", new Item(new FabricItemSettings()));
   public static final Item REFINED_OWENIUM = registerItem("refined_owenium", new Item(new FabricItemSettings()));
   public static final Item OWENIUM_DETECTOR = registerItem("owenium_detector", new OweniumDetectorItem((new FabricItemSettings()).maxDamage(512)));
   public static final Item NUCLEAR_OWENIUM= registerItem("nuclear_owenium", new Item(new FabricItemSettings()));
   public static final Item OWENIUM_APPLE= registerItem("owenium_apple", new Item(new FabricItemSettings().food(ModFoodComponents.OWENIUM_APPLE)));
   private static Item registerItem(String name, Item item) {
      return Registry.register(Registries.ITEM, new Identifier(Owenium.MOD_ID, name), item);
   }

   public static void registerModItems() {
      Owenium.LOGGER.info("Registering Mod Items for owenium");
   }
}
