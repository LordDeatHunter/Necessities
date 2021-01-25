package wraith.necessities.command;

import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;

public class CommandFunctions {

    public static void stackItem(ServerPlayerEntity player) {
        if (CommandFunctions.stackItem(player.getMainHandStack())) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("item.armor.equip_iron"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    public static boolean stackItem(ItemStack stack) {
        if (stack.isEmpty() || stack.getCount() >= stack.getMaxCount()) {
            return false;
        }
        stack.setCount(stack.getMaxCount());
        return true;
    }

    public static void repairItem(ServerPlayerEntity player, int amount) {
        ItemStack stack = player.getMainHandStack();
        if (amount < 0) {
            amount = stack.getMaxDamage();
        }
        if (setDamage(stack, Math.max(0, stack.getDamage() - amount))) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.smithing_table.use"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    public static boolean setDamage(ItemStack stack, int amount) {
        if (stack.isEmpty() || stack.getDamage() == amount) {
            return false;
        }
        stack.setDamage(amount);
        return true;
    }

    public static void damageItem(ServerPlayerEntity player, int amount) {
        ItemStack stack = player.getMainHandStack();
        if (amount < 0) {
            amount = stack.getMaxDamage();
        }
        if (setDamage(stack, Math.min(stack.getMaxDamage(), stack.getDamage() + amount))) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.anvil.destroy"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    public static void healPlayer(ServerPlayerEntity player, float amount) {
        if (amount < 0) {
            amount = player.getMaxHealth();
        }
        if (setHealth(player, Math.min(player.getMaxHealth(), player.getHealth() + amount))) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("item.bucket.fill_lava"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    public static void hurtPlayer(ServerPlayerEntity player, float amount) {
        if (amount < 0) {
            amount = player.getMaxHealth();
        }
        if (setHealth(player, Math.max(0, player.getHealth() - amount))) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("entity.generic.hurt"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    private static boolean setHealth(ServerPlayerEntity player, float health) {
        if (player.getHealth() == health) {
            return false;
        }
        player.setHealth(health);
        return true;
    }

    public static void disenchant(ServerPlayerEntity player) {
        if (disenchantTool(player.getMainHandStack())) {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.grindstone.use"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        } else {
            player.networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.ancient_debris.break"), SoundCategory.AMBIENT, player.getPos(), 1f, 1f));
        }
    }

    private static boolean disenchantTool(ItemStack stack) {
        if (stack.getEnchantments().isEmpty()) {
            return false;
        }
        stack.getTag().remove("Enchantments");
        return true;
    }

}
