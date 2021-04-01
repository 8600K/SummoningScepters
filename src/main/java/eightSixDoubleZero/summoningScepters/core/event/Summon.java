package eightSixDoubleZero.summoningScepters.core.event;

import eightSixDoubleZero.summoningScepters.common.entities.*;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Timer;

public class Summon {


    public static void summonZombie(PlayerInteractEvent event, int damageAmt, int type)
    {
        //Set up some basic variables for use.
        PlayerEntity entity = event.getPlayer();
        World worldIn = event.getWorld();
        EntityDamageSource mobDmg = new EntityDamageSource(DamageSource.OUT_OF_WORLD.bypassArmor().toString(), entity);
        EntityDamageSource playerDmg = new EntityDamageSource(DamageSource.GENERIC.toString(), entity);

        ITextComponent baseZombie = new StringTextComponent("\u00A72Summoned Zombie");
        ITextComponent berzerkerZombie = new StringTextComponent("\u00A7eBerzerker");
        ITextComponent hopliteZombie = new StringTextComponent("\u00A76Hoplite");

        //Create the zombie from the SummonedZombie class that overrides some methods.
        //Add more mobs for future releases.
        SummonedZombie zombie = new SummonedZombie(EntityType.ZOMBIE, worldIn);




        entity.hurt(playerDmg, damageAmt);
        entity.addEffect(new EffectInstance(Effects.HUNGER, 80, 2));
        //entity.attackEntityFrom(playerDmg, damageAmt);
        //entity.addPotionEffect(new EffectInstance(Effects.HUNGER, 80, 2));

        if (type == 1)  //Berzerker
        {

            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1f, 0.5f);
            entity.playSound(SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 0.5f, 0.5f);

            zombie.setItemInHand(Hand.MAIN_HAND, Items.IRON_AXE.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.HEAD, Items.LEATHER_HELMET.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.CHEST, Items.LEATHER_CHESTPLATE.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.LEGS, Items.LEATHER_LEGGINGS.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.FEET, Items.LEATHER_BOOTS.getDefaultInstance());

            zombie.setItemInHand(Hand.OFF_HAND, Items.IRON_AXE.getDefaultInstance());
            zombie.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.45f);
            zombie.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10.0f);
            zombie.setCustomName(berzerkerZombie);
            zombie.Berzerk();

            timeKeeper(zombie, mobDmg, 20000);



        } else if(type == 2)  //Tank
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.5f, 1f);
            entity.playSound(SoundEvents.IRON_GOLEM_REPAIR, 0.8f, 0.8f);

            ItemStack item = new ItemStack(Items.GOLDEN_AXE);

            item.enchant(Enchantments.SHARPNESS, 2);

            zombie.setItemInHand(Hand.OFF_HAND, Items.SHIELD.getDefaultInstance());
            zombie.setItemInHand(Hand.MAIN_HAND, item);
            zombie.setItemSlot(EquipmentSlotType.HEAD, Items.IRON_HELMET.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.CHEST, Items.IRON_CHESTPLATE.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.LEGS, Items.IRON_LEGGINGS.getDefaultInstance());
            zombie.setItemSlot(EquipmentSlotType.FEET, Items.IRON_BOOTS.getDefaultInstance());
            zombie.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.18f);
            zombie.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0f);
            zombie.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.5f);
            zombie.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(8.0f);
            zombie.setCustomName(hopliteZombie);



            SummonedZombie zombie1 = new SummonedZombie(EntityType.ZOMBIE, worldIn);
            zombie1.setItemInHand(Hand.OFF_HAND, Items.SHIELD.getDefaultInstance());
            zombie1.setItemInHand(Hand.MAIN_HAND, item);
            zombie1.setItemSlot(EquipmentSlotType.HEAD, Items.IRON_HELMET.getDefaultInstance());
            zombie1.setItemSlot(EquipmentSlotType.CHEST, Items.IRON_CHESTPLATE.getDefaultInstance());
            zombie1.setItemSlot(EquipmentSlotType.LEGS, Items.IRON_LEGGINGS.getDefaultInstance());
            zombie1.setItemSlot(EquipmentSlotType.FEET, Items.IRON_BOOTS.getDefaultInstance());
            zombie1.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.18f);
            zombie1.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30.0f);
            zombie1.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.5f);
            zombie1.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(8.0f);
            zombie1.setCustomName(hopliteZombie);




            zombie1.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
            worldIn.addFreshEntity(zombie1);

            timeKeeper(zombie, mobDmg, 60000);
            timeKeeper(zombie1, mobDmg, 60000);


        } else {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 0.5f, 0.5f);
            entity.playSound(SoundEvents.ZOMBIE_AMBIENT, 0.2f, 0.2f);

            zombie.setItemInHand(Hand.MAIN_HAND, Items.STONE_AXE.getDefaultInstance());
            timeKeeper(zombie, mobDmg, 15000);
            zombie.setCustomName(baseZombie);

        }

        zombie.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
        worldIn.addFreshEntity(zombie);

    }

    public static void summonSkeleton(PlayerInteractEvent event, int damageAmt, int type)
    {
        PlayerEntity entity = event.getPlayer();
        World worldIn = event.getWorld();
        EntityDamageSource mobDmg = new EntityDamageSource(DamageSource.OUT_OF_WORLD.toString(), entity);
        EntityDamageSource playerDmg = new EntityDamageSource(DamageSource.GENERIC.toString(), entity);

        SummonedSkeleton skeleton = new SummonedSkeleton(EntityType.SKELETON, worldIn);
        ITextComponent baseSkeleton = new StringTextComponent("\u00A72Summoned Skeleton");
        ITextComponent rangerSkeleton = new StringTextComponent("\u00A7eRanger");
        ITextComponent clericSkeleton = new StringTextComponent("\u00A76Cleric");
        entity.hurt(playerDmg, damageAmt);
        entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 160, 3));

        if(type == 1)
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1f, 0.5f);
            entity.playSound(SoundEvents.SKELETON_AMBIENT, 0.3f, 0.1f);


            ItemStack item = new ItemStack(Items.BOW);

            item.enchant(Enchantments.FLAMING_ARROWS, 2);
            skeleton.setItemInHand(Hand.MAIN_HAND, item);
            skeleton.setCustomName(rangerSkeleton);

            timeKeeper(skeleton, mobDmg, 30000);

        } else if(type == 2)
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.5f, 1f);
            entity.playSound(SoundEvents.SPLASH_POTION_THROW, 0.5f, 0.5f);


            ItemStack item = new ItemStack(Items.DIAMOND_SWORD);
            item.enchant(Enchantments.SMITE, 5);

            skeleton.setItemInHand(Hand.OFF_HAND, Items.POTION.getDefaultInstance());
            skeleton.setItemInHand(Hand.MAIN_HAND, item);
            skeleton.setItemSlot(EquipmentSlotType.HEAD, Items.LEATHER_HELMET.getDefaultInstance());
            skeleton.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
            skeleton.getAttribute(Attributes.MAX_HEALTH).setBaseValue(24.0);
            skeleton.setCustomName(clericSkeleton);

            timeKeeper(skeleton, mobDmg, 40000);

        } else {

            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 0.5f, 0.5f);
            entity.playSound(SoundEvents.CROSSBOW_LOADING_MIDDLE, 0.5f, 0.5f);


            skeleton.setItemInHand(Hand.MAIN_HAND, Items.BOW.getDefaultInstance());
            skeleton.setCustomName(baseSkeleton);
            timeKeeper(skeleton, mobDmg, 15000);

        }


        skeleton.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
        worldIn.addFreshEntity(skeleton);

    }

    public static void summonWitherSkeleton(PlayerInteractEvent event, int damageAmt, int type)
    {
        PlayerEntity entity = event.getPlayer();
        World worldIn = event.getWorld();
        EntityDamageSource mobDmg = new EntityDamageSource(DamageSource.OUT_OF_WORLD.toString(), entity);
        EntityDamageSource playerDmg = new EntityDamageSource(DamageSource.GENERIC.toString(), entity);
        ITextComponent baseWitherSkeleton = new StringTextComponent("\u00A72Summoned Wither Skeleton");
        ITextComponent warriorWitherSkeleton = new StringTextComponent("\u00A7eForgotten Warrior");
        ITextComponent ancientMinerWitherSkeleton = new StringTextComponent("\u00A76Ancient Miner");


        SummonedWitherSkeleton witherSkeleton = new SummonedWitherSkeleton(EntityType.WITHER_SKELETON, worldIn);
        entity.hurt(playerDmg, damageAmt);
        entity.addEffect(new EffectInstance(Effects.WITHER, 80, 1));

        if(type == 1)
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1f, 0.5f);
            entity.playSound(SoundEvents.WITHER_SHOOT, 0.2f, 0.1f);


            witherSkeleton.setItemInHand(Hand.MAIN_HAND, Items.IRON_SWORD.getDefaultInstance());
            witherSkeleton.setItemSlot(EquipmentSlotType.HEAD, Items.IRON_HELMET.getDefaultInstance());
            witherSkeleton.setCustomName(warriorWitherSkeleton);
            timeKeeper(witherSkeleton, mobDmg, 40000);

        } else if(type == 2) {

            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.5f, 1f);
            entity.playSound(SoundEvents.AMBIENT_CAVE, 1f, 0.3f);


            ItemStack item = new ItemStack(Items.DIAMOND_PICKAXE);
            ItemStack item1 = new ItemStack(Items.IRON_PICKAXE);
            item.enchant(Enchantments.FIRE_ASPECT, 2);
            item.enchant(Enchantments.SHARPNESS, 2);
            item1.enchant(Enchantments.SHARPNESS, 3);

            witherSkeleton.setItemInHand(Hand.MAIN_HAND, item);
            witherSkeleton.setItemInHand(Hand.OFF_HAND, item1);

            witherSkeleton.setItemSlot(EquipmentSlotType.HEAD, Items.DIAMOND_HELMET.getDefaultInstance());
            witherSkeleton.setItemSlot(EquipmentSlotType.CHEST, Items.IRON_CHESTPLATE.getDefaultInstance());
            witherSkeleton.getAttribute(Attributes.MAX_HEALTH).setBaseValue(28.0);
            witherSkeleton.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(1.0);
            witherSkeleton.setCustomName(ancientMinerWitherSkeleton);
            timeKeeper(witherSkeleton, mobDmg, 40000);



        } else {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 0.5f, 0.5f);
            entity.playSound(SoundEvents.WITHER_SKELETON_AMBIENT, 0.2f, 0.2f);


            witherSkeleton.setItemInHand(Hand.MAIN_HAND, Items.STONE_SWORD.getDefaultInstance());
            witherSkeleton.setCustomName(baseWitherSkeleton);
            timeKeeper(witherSkeleton, mobDmg, 20000);


        }


        witherSkeleton.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
        worldIn.addFreshEntity(witherSkeleton);

    }


    public static void summonHorse(PlayerInteractEvent event, int damageAmt, int delay)
    {

        PlayerEntity entity = event.getPlayer();

        entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1f, 0.5f);
        entity.playSound(SoundEvents.HORSE_BREATHE, 1f, 0.5f);

        World worldIn = event.getWorld();
        EntityDamageSource mobDmg = new EntityDamageSource(DamageSource.OUT_OF_WORLD.toString(), entity);
        EntityDamageSource playerDmg = new EntityDamageSource(DamageSource.GENERIC.toString(), entity);

        SummonedHorse horse = new SummonedHorse(EntityType.HORSE, worldIn);
        ITextComponent name = new StringTextComponent("\u00A7eSummoned Horse");
        horse.setCustomName(name);
        entity.hurt(playerDmg, damageAmt);
        entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 140, 1));
        horse.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
        worldIn.addFreshEntity(horse);

        timeKeeper(horse, mobDmg, delay);
    }

    public static void summonStray(PlayerInteractEvent event, int damageAmt, int type)
    {
        PlayerEntity entity = event.getPlayer();
        World worldIn = event.getWorld();
        EntityDamageSource mobDmg = new EntityDamageSource(DamageSource.OUT_OF_WORLD.toString(), entity);
        EntityDamageSource playerDmg = new EntityDamageSource(DamageSource.GENERIC.toString(), entity);

        SummonedStray stray = new SummonedStray(EntityType.STRAY, worldIn);
        ITextComponent baseStray = new StringTextComponent("\u00A72Summoned Stray");
        ITextComponent lesserStray = new StringTextComponent("\u00A7eLesser Stray");
        ITextComponent greaterStray = new StringTextComponent("\u00A76Greater Stray");
        entity.hurt(playerDmg, damageAmt);
        entity.addEffect(new EffectInstance(Effects.WEAKNESS, 160, 3));

        if(type == 1)
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1f, 0.5f);
            entity.playSound(SoundEvents.STRAY_AMBIENT, 0.7f, 0.7f);

            ItemStack item = new ItemStack(Items.BOW);

            item.enchant(Enchantments.PUNCH_ARROWS, 1);
            item.enchant(Enchantments.POWER_ARROWS, 2);

            stray.setItemSlot(EquipmentSlotType.HEAD, Items.CHAINMAIL_HELMET.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.CHEST, Items.CHAINMAIL_CHESTPLATE.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.LEGS, Items.LEATHER_LEGGINGS.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.FEET, Items.LEATHER_BOOTS.getDefaultInstance());
            stray.setItemInHand(Hand.MAIN_HAND, item);
            stray.setCustomName(lesserStray);
            timeKeeper(stray, mobDmg, 30000);

        } else if(type == 2)
        {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 1.5f, 1f);
            entity.playSound(SoundEvents.CROSSBOW_SHOOT, 0.2f,0.2f);
            ItemStack item = new ItemStack(Items.BOW);

            item.enchant(Enchantments.PUNCH_ARROWS, 3);
            item.enchant(Enchantments.POWER_ARROWS, 4);

            stray.setItemSlot(EquipmentSlotType.HEAD, Items.CHAINMAIL_HELMET.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.CHEST, Items.CHAINMAIL_CHESTPLATE.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.LEGS, Items.CHAINMAIL_LEGGINGS.getDefaultInstance());
            stray.setItemSlot(EquipmentSlotType.FEET, Items.CHAINMAIL_BOOTS.getDefaultInstance());
            stray.setItemInHand(Hand.MAIN_HAND, item);

            stray.setCustomName(greaterStray);
            timeKeeper(stray, mobDmg, 50000);
        } else {
            entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 0.5f, 0.5f);


            stray.setItemInHand(Hand.MAIN_HAND, Items.BOW.getDefaultInstance());
            stray.setCustomName(baseStray);
            timeKeeper(stray, mobDmg, 15000);
        }


        stray.setPos(entity.getX() + 1, entity.getY(), entity.getZ());
        worldIn.addFreshEntity(stray);


    }



    private static void timeKeeper(Entity entity, EntityDamageSource dmg, int delay)
    {
        Timer timer = new java.util.Timer();

        timer.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        entity.hurt(dmg, 128);
                        timer.cancel();
                    }
                },
                delay
        );

    }




}
