package shatterdpotato.owenium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_OF_OWENIUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUCLEAR_OWENIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_OWENIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OWENIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OWENIUM_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OWENIUM_EMITTER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NUCLEAR_OWENIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWENIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWENIUM_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWENIUM_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.REFINED_OWENIUM, Models.GENERATED);
    }
}
