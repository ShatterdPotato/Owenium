package shatterdpotato.owenium.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import shatterdpotato.owenium.Owenium;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OWENIUM_DETECTOR_DETECTABLE = createTag("owenium_detector_detectable");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Owenium.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Owenium.MOD_ID, name));
        }
    }
}
