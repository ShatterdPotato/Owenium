package shatterdpotato.owenium;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import shatterdpotato.owenium.datagen.*;

public class OweniumDataGenerator implements DataGeneratorEntrypoint {
   public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
      FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

      pack.addProvider(ModBlockTagProvider::new);
//      pack.addProvider(ModItemTagProvider::new);
      pack.addProvider(ModLootTableProvider::new);
      pack.addProvider(ModModelProvider::new);
      pack.addProvider(ModRecipeProvider::new);
   }

}
