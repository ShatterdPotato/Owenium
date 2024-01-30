package shatterdpotato.owenium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.item.ModItems;
import shatterdpotato.owenium.item.ModItemsGroup;
import shatterdpotato.owenium.sound.ModSounds;

public class Owenium implements ModInitializer {
   public static final String MOD_ID = "owenium";
   public static final Logger LOGGER = LoggerFactory.getLogger("owenium");

   public void onInitialize() {
      ModItemsGroup.registerItemGroups();
      ModSounds.registerModSounds();
      ModItems.registerModItems();
      ModBlocks.registerModBlocks();
      FuelRegistry.INSTANCE.add(ModItems.NUCLEAR_OWENIUM, 200);
      FuelRegistry.INSTANCE.add(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM, 2000);
   }
}
