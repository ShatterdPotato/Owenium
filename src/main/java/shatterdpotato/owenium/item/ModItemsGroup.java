package shatterdpotato.owenium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import shatterdpotato.owenium.Owenium;
import shatterdpotato.owenium.block.ModBlocks;

public class ModItemsGroup {
   public static final ItemGroup OWENIUM = Registry.register(Registries.ITEM_GROUP,
           new Identifier(Owenium.MOD_ID, "ruby"),
           FabricItemGroup.builder().displayName(Text.translatable("itemgroup.owenium"))
                   .icon(() -> new ItemStack(ModItems.OWENIUM)).entries((displayContext, entries) -> {
                     entries.add(ModItems.OWENIUM);
                     entries.add(ModItems.REFINED_OWENIUM);
                     entries.add(ModItems.OWENIUM_DETECTOR);
                     entries.add(ModItems.OWENIUM_APPLE);
                     entries.add(ModItems.NUCLEAR_OWENIUM);
                     entries.add(ModBlocks.BLOCK_OF_OWENIUM);
                     entries.add(ModBlocks.OWENIUM_PLANKS);
                     entries.add(ModBlocks.OWENIUM_ORE);
                     entries.add(ModBlocks.NUCLEAR_OWENIUM_ORE);
                     entries.add(ModBlocks.DEEPSLATE_OWENIUM_ORE);
                     entries.add(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE);
                     entries.add(ModBlocks.OWENIUM_EMITTER);
                     entries.add(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER);
                     entries.add(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM);
   }).build());

   public static void registerItemGroups() {
      Owenium.LOGGER.info("Registering Item Groups for owenium");
   }

}
