package shatterdpotato.owenium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import shatterdpotato.owenium.Owenium;
import shatterdpotato.owenium.block.custom.CompressedNuclearOweniumBlock;
import shatterdpotato.owenium.block.custom.EnlightenedOweniumEmitterBlock;
import shatterdpotato.owenium.block.custom.OweniumEmitterBlock;

public class ModBlocks {
   public static final Block  BLOCK_OF_OWENIUM = registerBlock("block_of_owenium", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
   public static final Block OWENIUM_PLANKS = registerBlock("owenium_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
   public static final Block OWENIUM_ORE = registerBlock("owenium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
   public static final Block DEEPSLATE_OWENIUM_ORE = registerBlock("deepslate_owenium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE)));
   public static final Block NUCLEAR_OWENIUM_ORE = registerBlock("nuclear_owenium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).luminance(9)));
   public static final Block DEEPSLATE_NUCLEAR_OWENIUM_ORE = registerBlock("deepslate_nuclear_owenium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).luminance(9)));
   public static final Block OWENIUM_EMITTER = registerBlock("owenium_emitter", new OweniumEmitterBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
   public static final Block ENLIGHTENED_OWENIUM_EMITTER = registerBlock("enlightened_owenium_emitter", new EnlightenedOweniumEmitterBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
   public static final Block COMPRESSED_NUCLEAR_OWENIUM = registerBlock("compressed_nuclear_owenium", new CompressedNuclearOweniumBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).luminance(15)));

   private static Block registerBlock(String name, Block block) {
      registerBlockItem(name, block);
      return Registry.register(Registries.BLOCK, new Identifier(Owenium.MOD_ID, name), block);
   }

   private static Item registerBlockItem(String name, Block block) {
      return Registry.register(Registries.ITEM, new Identifier(Owenium.MOD_ID, name),
              new BlockItem(block, new FabricItemSettings()));
   }

   public static void registerModBlocks() {
      Owenium.LOGGER.info("Registering ModBlocks for owenium");
   }

}
