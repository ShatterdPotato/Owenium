package shatterdpotato.owenium.block.custom;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import shatterdpotato.owenium.sound.ModSounds;

public class OweniumEmitterBlock extends Block {
   public OweniumEmitterBlock(Settings settings) {
      super(settings);
   }

   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
      Random random = new Random();
      int sound_choice = random.nextInt(2) + 1;
      if (sound_choice == 1) {
         world.playSound(player, pos, ModSounds.OWENIUM_DIALOG_1, SoundCategory.BLOCKS, 1.0F, 1.0F);
      } else if (sound_choice == 2) {
         world.playSound(player, pos, ModSounds.OWENIUM_DIALOG_2, SoundCategory.BLOCKS, 1.0F, 1.0F);
      }

      return ActionResult.SUCCESS;
   }
}
