package eightSixDoubleZero.summoningScepters.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SummonedWitherSkeleton extends WitherSkeletonEntity {
    public SummonedWitherSkeleton(EntityType<? extends WitherSkeletonEntity> p_i50187_1_, World p_i50187_2_) {
        super(p_i50187_1_, p_i50187_2_);
    }

    private static final Predicate<LivingEntity> SUMMONS = (p_213797_0_) -> {
        return p_213797_0_.getEntity().getClass() != SummonedZombie.class && p_213797_0_.getEntity().getClass() != SummonedWitherSkeleton.class
                && p_213797_0_.getEntity().getClass() != SummonedSkeleton.class && p_213797_0_.getEntity().getClass() != SummonedHorse.class
                && p_213797_0_.getEntity().getClass() != SummonedStray.class;

    };

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new RestrictSunGoal(this));
        this.goalSelector.addGoal(4, new FleeSunGoal(this, 1.2d));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 0, false, false, SUMMONS));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
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
