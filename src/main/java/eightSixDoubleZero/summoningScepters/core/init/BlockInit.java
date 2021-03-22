package eightSixDoubleZero.summoningScepters.core.init;

import eightSixDoubleZero.summoningScepters.MainSetup;
import eightSixDoubleZero.summoningScepters.common.blocks.Lightning_Rod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MainSetup.MOD_ID);

    public static final RegistryObject<Lightning_Rod> LIGHTNING_ROD =
            BLOCKS.register("lightning_rod", () ->
                    new Lightning_Rod(AbstractBlock.Properties.of(Material.HEAVY_METAL)
                            .sound(SoundType.METAL)
                            .harvestTool(ToolType.PICKAXE)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
                            .strength(18f, 27f)
                            .harvestLevel(1)));


}
