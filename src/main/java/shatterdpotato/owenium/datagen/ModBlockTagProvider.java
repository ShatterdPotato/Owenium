package shatterdpotato.owenium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.OWENIUM_DETECTOR_DETECTABLE)
                .add(ModBlocks.OWENIUM_ORE)
                .add(ModBlocks.DEEPSLATE_OWENIUM_ORE)
                .add(ModBlocks.NUCLEAR_OWENIUM_ORE)
                .add(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLOCK_OF_OWENIUM)
                .add(ModBlocks.DEEPSLATE_OWENIUM_ORE)
                .add(ModBlocks.OWENIUM_ORE)
                .add(ModBlocks.NUCLEAR_OWENIUM_ORE)
                .add(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE)
                .add(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM)
                .add(ModBlocks.OWENIUM_EMITTER)
                .add(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.OWENIUM_PLANKS);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add((ModBlocks.OWENIUM_PLANKS));

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOCK_OF_OWENIUM)
                .add(ModBlocks.DEEPSLATE_OWENIUM_ORE)
                .add(ModBlocks.OWENIUM_ORE)
                .add(ModBlocks.OWENIUM_EMITTER)
                .add(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NUCLEAR_OWENIUM_ORE)
                .add(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE)
                .add(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM);

    }
}
