package eightSixDoubleZero.summoningScepters.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WoodenStaff extends Item {
    public WoodenStaff(Properties properties) {
        super(properties);
    }



    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        if(!playerIn.getCooldowns().isOnCooldown(this)) {
            playerIn.getCooldowns().addCooldown(this, 600);
            //playerIn.getCooldownTracker().setCooldown(ItemInit.ENDER_STAFF.get().getItem(), 20);
            return ActionResult.success(playerIn.getMainHandItem());


        }
        return ActionResult.fail(playerIn.getMainHandItem());
    }*/

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerIn, Hand hand) {
        if(!playerIn.getCooldowns().isOnCooldown(this)) {
            playerIn.getCooldowns().addCooldown(this, 600);

            return ActionResult.success(playerIn.getMainHandItem());


        }
        return ActionResult.fail(playerIn.getMainHandItem());
    }
}
