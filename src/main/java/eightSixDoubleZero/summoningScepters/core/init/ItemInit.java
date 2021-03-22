package eightSixDoubleZero.summoningScepters.core.init;

import eightSixDoubleZero.summoningScepters.MainSetup;
import eightSixDoubleZero.summoningScepters.common.items.GoldenScepter;
import eightSixDoubleZero.summoningScepters.common.items.ObsidianScepter;
import eightSixDoubleZero.summoningScepters.common.items.WoodenStaff;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MainSetup.MOD_ID);


    //ITEMS
    public static final RegistryObject<ObsidianScepter> OBSIDIAN_SCEPTER =
            ITEMS.register("obsidian_scepter", () -> new ObsidianScepter(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<WoodenStaff> WOODEN_STAFF =
            ITEMS.register("wooden_staff", () -> new WoodenStaff(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<GoldenScepter> GOLDEN_SCEPTER =
            ITEMS.register("golden_scepter", () -> new GoldenScepter(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_GRIP =
            ITEMS.register("reinforced_grip", () -> new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS)));

    public static final RegistryObject<Item> ZOMBIE_SUMMON_TOME =
            ITEMS.register("zombie_summon_tome", () ->
                    new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<Item> SKELETON_SUMMON_TOME =
            ITEMS.register("skeleton_summon_tome", () ->
                    new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<Item> HORSE_SUMMON_TOME =
            ITEMS.register("horse_summon_tome", () ->
                    new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<Item> STRAY_SUMMON_TOME =
            ITEMS.register("stray_summon_tome", () ->
                    new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));

    public static final RegistryObject<Item> WITHER_SKELETON_SUMMON_TOME =
            ITEMS.register("wither_skeleton_summon_tome", () ->
                    new Item(new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS).stacksTo(1)));


    //BLOCK ITEMS
    public static final RegistryObject<BlockItem> LIGHTNING_ROD =
            ITEMS.register("lightning_rod", () ->
                    new BlockItem(BlockInit.LIGHTNING_ROD.get(), new Item.Properties().tab(MainSetup.SUMMONING_SCEPTERS)));

}
