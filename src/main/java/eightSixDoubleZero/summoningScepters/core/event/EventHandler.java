package eightSixDoubleZero.summoningScepters.core.event;

import eightSixDoubleZero.summoningScepters.MainSetup;
import eightSixDoubleZero.summoningScepters.common.blocks.Lightning_Rod;
import eightSixDoubleZero.summoningScepters.core.init.ItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.Timer;

@Mod.EventBusSubscriber(modid = MainSetup.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {


    @SubscribeEvent
    public static void commenceTheGrandSummoning(final PlayerInteractEvent.RightClickItem event) {
        PlayerEntity entity = event.getPlayer();
        Hand hand = event.getHand();
        World worldIn = event.getWorld();

        if (entity.getItemInHand(Hand.OFF_HAND).getItem() == ItemInit.ZOMBIE_SUMMON_TOME.get()) {
            if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.WOODEN_STAFF.get() && ItemInit.WOODEN_STAFF.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonZombie(event, 4, 0);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_SCEPTER.get() && ItemInit.GOLDEN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonZombie(event, 6, 1);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.OBSIDIAN_SCEPTER.get() && ItemInit.OBSIDIAN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonZombie(event, 8, 2);
            }
        } else if (entity.getItemInHand(Hand.OFF_HAND).getItem() == ItemInit.SKELETON_SUMMON_TOME.get()) {
            if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.WOODEN_STAFF.get() && ItemInit.WOODEN_STAFF.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonSkeleton(event, 4, 0);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_SCEPTER.get() && ItemInit.GOLDEN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonSkeleton(event, 6, 1);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.OBSIDIAN_SCEPTER.get() && ItemInit.OBSIDIAN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonSkeleton(event, 8, 2);
            }
        } else if (entity.getItemInHand(Hand.OFF_HAND).getItem() == ItemInit.WITHER_SKELETON_SUMMON_TOME.get()) {
            if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.WOODEN_STAFF.get() && ItemInit.WOODEN_STAFF.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonWitherSkeleton(event, 4, 0);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_SCEPTER.get() && ItemInit.GOLDEN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonWitherSkeleton(event, 6, 1);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.OBSIDIAN_SCEPTER.get() && ItemInit.OBSIDIAN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonWitherSkeleton(event, 8, 2);
            }
        } else if (entity.getItemInHand(Hand.OFF_HAND).getItem() == ItemInit.STRAY_SUMMON_TOME.get()) {
            if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.WOODEN_STAFF.get() && ItemInit.WOODEN_STAFF.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonStray(event, 4, 0);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_SCEPTER.get() && ItemInit.GOLDEN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonStray(event, 6, 1);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.OBSIDIAN_SCEPTER.get() && ItemInit.OBSIDIAN_SCEPTER.get().use(worldIn, entity, Hand.MAIN_HAND).getResult() == ActionResultType.SUCCESS) {
                Summon.summonStray(event, 8, 2);
            }
        } else if (entity.getItemInHand(Hand.OFF_HAND).getItem() == ItemInit.HORSE_SUMMON_TOME.get()) {

            //Current Change with the horse.
            if(entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.WOODEN_STAFF.get())
            {
                Summon.summonHorse(event, 4, 60000);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_SCEPTER.get()) {
                Summon.summonHorse(event, 5, 180000);
            } else if (entity.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.OBSIDIAN_SCEPTER.get())
            {
                Summon.summonHorse(event, 6, 300000);
            }

        }


    }


    @SubscribeEvent
    public static void lightningRod(final BlockEvent.EntityPlaceEvent event)
    {

        Entity entity = event.getEntity();
        BlockPos pos = event.getPos();
        //BlockState state = event.getState();  Variable not needed at this time.




        BlockState block = event.getPlacedBlock();




        if(block.getBlock() instanceof Lightning_Rod && entity.getCommandSenderWorld().isThundering())
        {
            Random random = new Random();

            LightningBoltEntity lightningBoltEntity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, entity.getCommandSenderWorld());

            lightningBoltEntity.setPos(pos.getX(), pos.getY(), pos.getZ());

            int rando = random.nextInt(100);
            if(rando > 900)
                timeKeeper(50000, entity, lightningBoltEntity, pos);
            else if(rando > 800)
                timeKeeper(45000, entity, lightningBoltEntity, pos);
            else if(rando > 700)
                timeKeeper(40000, entity, lightningBoltEntity, pos);
            else if(rando > 600)
                timeKeeper(35000, entity, lightningBoltEntity, pos);
            else if(rando > 500)
                timeKeeper(30000, entity, lightningBoltEntity, pos);
            else if(rando > 400)
                timeKeeper(25000, entity, lightningBoltEntity, pos);
            else if(rando > 300)
                timeKeeper(20000, entity, lightningBoltEntity, pos);
            else if(rando > 200)
                timeKeeper(15000, entity, lightningBoltEntity, pos);
            else if(rando > 100)
                timeKeeper(10000, entity, lightningBoltEntity, pos);
            else
                timeKeeper(5000, entity, lightningBoltEntity, pos);





            //entity.getEntityWorld().addEntity(lightningBoltEntity);

        }


    }


    public static void timeKeeper(int delay, Entity entity, Entity lightningBoltEntity, BlockPos pos)
    {
        Timer timer = new java.util.Timer();

        timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        entity.getCommandSenderWorld().addFreshEntity(lightningBoltEntity);
                        entity.getCommandSenderWorld().setBlock(pos, Blocks.AIR.defaultBlockState(),
                                Constants.BlockFlags.BLOCK_UPDATE);
                    }
                },
                delay
        );

    }






    private static void setBlocks(IWorld world, BlockPos pos)
    {
        for(int x = -5; x < 5; x++)
        {
            for(int y = -5; y < 5; y++)
            {
                for(int z = -5; z < 5; z++)
                {
                    world.setBlock(pos.offset(x, y, z), Blocks.AIR.defaultBlockState(),
                            Constants.BlockFlags.BLOCK_UPDATE);
                }
            }
        }
    }


}
