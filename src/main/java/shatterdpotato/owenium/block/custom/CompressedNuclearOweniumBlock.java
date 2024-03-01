package shatterdpotato.owenium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import shatterdpotato.owenium.sound.ModSounds;

import java.util.List;
import java.util.function.BiConsumer;

public class CompressedNuclearOweniumBlock extends Block {
    public CompressedNuclearOweniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(isReactive(player)) {
            ItemUsageContext context = new ItemUsageContext(player, hand, hit);
            player.getInventory().getMainHandStack().getItem().useOnBlock(context);
            world.playSound(player, pos, ModSounds.OWENIUM_EXPLOSION, SoundCategory.BLOCKS, 10.0F, 1.0F);
            world.removeBlock(pos,false);
            world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),20, true,World.ExplosionSourceType.TNT);

        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.owenium.compressed_nuclear_owenium"));
        super.appendTooltip(stack, world, tooltip, options);
    }

    public void onExploded(BlockState state, World world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        if (!(explosion.getPosition() == (pos.toCenterPos()))) {
            world.playSoundAtBlockCenter(pos, ModSounds.OWENIUM_EXPLOSION, SoundCategory.BLOCKS, 10f, 1f, true);
            world.removeBlock(pos, false);
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 20, true, World.ExplosionSourceType.TNT);
        }
    }

    private boolean isReactive(PlayerEntity player) {
        String hand_Item = player.getInventory().getMainHandStack().getItem().toString();
        return hand_Item.equals("nuclear_owenium") || hand_Item.equals("compressed_nuclear_owenium");
    }
}
