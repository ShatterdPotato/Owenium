package shatterdpotato.owenium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOCK_OF_OWENIUM);
        addDrop(ModBlocks.OWENIUM_EMITTER);
        addDrop(ModBlocks.COMPRESSED_NUCLEAR_OWENIUM);
        addDrop(ModBlocks.ENLIGHTENED_OWENIUM_EMITTER);
        addDrop(ModBlocks.OWENIUM_PLANKS);

        addDrop(ModBlocks.OWENIUM_ORE, oreDrops(ModBlocks.OWENIUM_ORE, ModItems.OWENIUM));
        addDrop(ModBlocks.DEEPSLATE_OWENIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_OWENIUM_ORE, ModItems.OWENIUM));
        addDrop(ModBlocks.NUCLEAR_OWENIUM_ORE, multiOreDrops(ModBlocks.NUCLEAR_OWENIUM_ORE, ModItems.NUCLEAR_OWENIUM));
        addDrop(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE, multiOreDrops(ModBlocks.DEEPSLATE_NUCLEAR_OWENIUM_ORE, ModItems.NUCLEAR_OWENIUM));

    }
    public LootTable.Builder multiOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 4.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
