package eightSixDoubleZero.summoningScepters.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SummonedSkeleton extends SkeletonEntity {
    public SummonedSkeleton(EntityType<? extends SkeletonEntity> type, World world) {
        super(type, world);
    }

    private static final Predicate<LivingEntity> SUMMONS = (p_213797_0_) -> {
        return p_213797_0_.getEntity().getClass() != SummonedZombie.class && p_213797_0_.getEntity().getClass() != SummonedWitherSkeleton.class
                && p_213797_0_.getEntity().getClass() != SummonedSkeleton.class && p_213797_0_.getEntity().getClass() != SummonedHorse.class
                && p_213797_0_.getEntity().getClass() != SummonedStray.class;

    };

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 0, false, false, SUMMONS));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
    }

    @Override
    protected boolean shouldDropLoot() {
        return false;
    }

    @Override
    protected boolean shouldDropExperience() {
        return false;
    }
}
