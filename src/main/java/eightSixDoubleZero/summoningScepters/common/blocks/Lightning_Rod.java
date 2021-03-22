package eightSixDoubleZero.summoningScepters.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class Lightning_Rod extends BaseHorizontal{

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(7, 0, 7, 9, 28.6, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.join(v1, v2, IBooleanFunction.OR);}).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.getValue(HORIZONTAL_FACING));
    }

    public Lightning_Rod(Properties properties) {
        super(properties);
        runCalculation(SHAPE);
    }
}
