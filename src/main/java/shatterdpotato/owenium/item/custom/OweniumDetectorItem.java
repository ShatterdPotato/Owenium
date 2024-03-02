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
import shatterdpotato.owenium.util.ModTags;

import java.util.List;

public class OweniumDetectorItem extends Item {
   public OweniumDetectorItem(Settings settings) {
      super(settings);
   }

   public ActionResult useOnBlock(ItemUsageContext context) {

      if (context.getWorld().isClient) {
         BlockPos positionClicked = context.getBlockPos();
         PlayerEntity player = context.getPlayer();
         boolean foundBlock = false;

         for(int i = 0; i <= positionClicked.getY() + 64; ++i) {
            BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
            if (isValuableBlock(state)) {
               context.getWorld().playSound(context.getPlayer(), context.getPlayer().getBlockPos(), ModSounds.OWENIUM_FOUND, SoundCategory.AMBIENT, 1, 1);
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

   @Override
   public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
      tooltip.add(Text.translatable("tooltip.owenium.owenium_detector"));
      super.appendTooltip(stack, world, tooltip, context);
   }

   private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block, ItemUsageContext context) {
      String found_block = block.asItem().getName().getString();
      player.sendMessage(Text.translatable(found_block + " found at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
   }

   private boolean isValuableBlock(BlockState state) {
      return state.isIn(ModTags.Blocks.OWENIUM_DETECTOR_DETECTABLE);
   }

}
