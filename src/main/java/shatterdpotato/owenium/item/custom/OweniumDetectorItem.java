package shatterdpotato.owenium.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import shatterdpotato.owenium.block.ModBlocks;
import shatterdpotato.owenium.sound.ModSounds;
import net.minecraft.world.World;

public class OweniumDetectorItem extends Item {
   public OweniumDetectorItem(Settings settings) {
      super(settings);
   }

   public ActionResult useOnBlock(ItemUsageContext context) {
      if (!context.getWorld().isClient) {
         BlockPos positionClicked = context.getBlockPos();
         PlayerEntity player = context.getPlayer();
         boolean foundBlock = false;

         for(int i = 0; i <= positionClicked.getY() + 64; ++i) {
            BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
            if (isValuableBlock(state)) {
               outputValuableCoordinates(positionClicked.down(i), player, state.getBlock(), context);
               foundBlock = true;
               break;
            }
         }

         if (!foundBlock) {
            player.sendMessage(Text.translatable("No Owenium Detected :("));
         }
      }

      context.getStack().damage(1, context.getPlayer(),
              playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
      return ActionResult.SUCCESS;
   }

   private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block, ItemUsageContext context) {
      player.sendMessage(Text.translatable("O W E N I U M  found at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
      World world = context.getWorld();
      world.playSound(player, blockPos, ModSounds.OWENIUM_FOUND, SoundCategory.BLOCKS, 1, 1);
   }

   private boolean isValuableBlock(BlockState state) {
      return state.isOf(ModBlocks.OWENIUM_ORE) || state.isOf(ModBlocks.DEEPSLATE_OWENIUM_ORE);
   }
}
