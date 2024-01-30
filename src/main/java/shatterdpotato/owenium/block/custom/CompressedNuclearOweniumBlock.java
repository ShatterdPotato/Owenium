package shatterdpotato.owenium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompressedNuclearOweniumBlock extends Block {
    public CompressedNuclearOweniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getInventory().getMainHandStack().getItem().toString().equals("nuclear_owenium")) {
            world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),10, true,World.ExplosionSourceType.TNT);
        }

        return ActionResult.SUCCESS;
    }
}
