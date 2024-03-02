package shatterdpotato.owenium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> OWENIUM_SMELTABLES = List.of(ModItems.OWENIUM, ModBlocks.OWENIUM_ORE,ModBlocks.DEEPSLATE_OWENIUM_ORE);
    private static List<ItemConvertible> NUCLEAR_OWENIUM_SMELTABLES = List.of(ModItems.NUCLEAR_OWENIUM, ModBlocks.NUCLEAR_OWENIUM_ORE,ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, OWENIUM_SMELTABLES, RecipeCategory.MISC, ModItems.REFINED_OWENIUM,
                1, 200, "owenium" );
        offerBlasting(exporter, OWENIUM_SMELTABLES, RecipeCategory.MISC, ModItems.REFINED_OWENIUM,
                1, 100, "owenium" );
        offerSmelting(exporter, NUCLEAR_OWENIUM_SMELTABLES, RecipeCategory.MISC, ModItems.NUCLEAR_OWENIUM,
                1, 200, "owenium" );
        offerBlasting(exporter, NUCLEAR_OWENIUM_SMELTABLES, RecipeCategory.MISC, ModItems.NUCLEAR_OWENIUM,
                1, 100, "owenium" );

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.REFINED_OWENIUM, RecipeCategory.DECORATIONS, ModBlocks.BLOCK_OF_OWENIUM);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.NUCLEAR_OWENIUM, RecipeCategory.DECORATIONS, ModBlocks.COMPRESSED_NUCLEAR_OWENIUM);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OWENIUM_APPLE, 1)
                .pattern("###")
                .pattern("#$#")
                .pattern("###")
                .input('#', ModItems.REFINED_OWENIUM)
                .input('$', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(ModItems.REFINED_OWENIUM), conditionsFromItem(ModItems.REFINED_OWENIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.OWENIUM_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OWENIUM_PLANKS, 1)
                .pattern("###")
                .pattern("#$#")
                .pattern("###")
                .input('#', ItemTags.PLANKS)
                .input('$', ModItems.REFINED_OWENIUM)
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromTag(ItemTags.PLANKS))
                .criterion(hasItem(ModItems.REFINED_OWENIUM), conditionsFromItem(ModItems.REFINED_OWENIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OWENIUM_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ENLIGHTENED_OWENIUM_EMITTER, 1)
                .pattern(" # ")
                .pattern("#$#")
                .pattern(" # ")
                .input('#', Items.BOOKSHELF)
                .input('$', ModBlocks.OWENIUM_EMITTER)
                .criterion(hasItem(Items.BOOKSHELF), conditionsFromItem(Items.BOOKSHELF))
                .criterion(hasItem(ModBlocks.OWENIUM_EMITTER), conditionsFromItem(ModBlocks.OWENIUM_EMITTER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.OWENIUM_EMITTER, 1)
                .pattern("@#@")
                .pattern("#$#")
                .pattern("@#@")
                .input('#', Items.DIAMOND)
                .input('$', Items.NOTE_BLOCK)
                .input('@', ModItems.REFINED_OWENIUM)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.NOTE_BLOCK), conditionsFromItem(Items.NOTE_BLOCK))
                .criterion(hasItem(ModItems.REFINED_OWENIUM), conditionsFromItem(ModItems.REFINED_OWENIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.OWENIUM_EMITTER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OWENIUM_DETECTOR, 1)
                .pattern("#@#")
                .pattern("###")
                .pattern(" $ ")
                .input('#', Items.IRON_INGOT)
                .input('$', Items.STICK)
                .input('@', ModItems.REFINED_OWENIUM)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.REFINED_OWENIUM), conditionsFromItem(ModItems.REFINED_OWENIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.OWENIUM_DETECTOR)));



    }
}
