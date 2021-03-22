package eightSixDoubleZero.summoningScepters.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.world.World;

public class SummonedHorse extends HorseEntity {
    public SummonedHorse(EntityType<? extends HorseEntity> type, World world) {
        super(type, world);
    }

    @Override
    public boolean isTamed() {
        return true;
    }

    @Override
    public boolean canMate(AnimalEntity otherAnimal) {
        return false;
    }

    @Override
    protected boolean shouldDropExperience() {
        return false;
    }

    @Override
    protected boolean shouldDropLoot() {
        return false;
    }
}
