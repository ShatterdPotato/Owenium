package shatterdpotato.owenium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import shatterdpotato.owenium.sound.ModSounds;

import java.util.function.BiConsumer;

public class CompressedNuclearOweniumBlock extends Block {
    public CompressedNuclearOweniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getInventory().getMainHandStack().getItem().toString().equals("nuclear_owenium")) {
            world.playSound(player, pos, ModSounds.OWENIUM_EXPLOSION, SoundCategory.BLOCKS, 10.0F, 1.0F);
            world.removeBlock(pos,true);
            world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),45, true,World.ExplosionSourceType.TNT);

        }

        return ActionResult.SUCCESS;
    }
    public void onExploded(BlockState state, World world, BlockPos pos, Explosion explosion, BiConsumer<ItemStack, BlockPos> stackMerger) {
        world.playSoundAtBlockCenter(pos, ModSounds.OWENIUM_EXPLOSION, SoundCategory.BLOCKS, 10f, 1f, true);
        world.removeBlock(pos,true);
        world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),45, true,World.ExplosionSourceType.TNT);
    }
}
