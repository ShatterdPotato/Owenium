package shatterdpotato.owenium.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import shatterdpotato.owenium.Owenium;

public class ModSounds {
   public static SoundEvent OWENIUM_DIALOG_1 = registerSoundEvent("owenium_dialog_1");
   public static SoundEvent OWENIUM_DIALOG_2 = registerSoundEvent("owenium_dialog_2");
   public static SoundEvent ENLIGHTENED_OWENIUM_DIALOG_1 = registerSoundEvent("enlightened_owenium_dialog_1");
   public static SoundEvent ENLIGHTENED_OWENIUM_DIALOG_2 = registerSoundEvent("enlightened_owenium_dialog_2");
   public static SoundEvent ENLIGHTENED_OWENIUM_DIALOG_3 = registerSoundEvent("enlightened_owenium_dialog_3");

   private static SoundEvent registerSoundEvent(String name) {
      Identifier id = new Identifier(Owenium.MOD_ID, name);
      return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
   }

   public static void registerModSounds() {
      Owenium.LOGGER.debug("Registering ModSounds for owenium");
   }
}
