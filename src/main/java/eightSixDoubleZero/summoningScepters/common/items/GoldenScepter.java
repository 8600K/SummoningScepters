package eightSixDoubleZero.summoningScepters.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GoldenScepter extends Item {
    public GoldenScepter(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        if(!playerIn.getCooldowns().isOnCooldown(this)) {
            playerIn.getCooldowns().addCooldown(this, 840);
            //playerIn.getCooldownTracker().setCooldown(ItemInit.ENDER_STAFF.get().getItem(), 20);
            return ActionResult.success(playerIn.getMainHandItem());


        }
        return ActionResult.fail(playerIn.getMainHandItem());
    }

}
