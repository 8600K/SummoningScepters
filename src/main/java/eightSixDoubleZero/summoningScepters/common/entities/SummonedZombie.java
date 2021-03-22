package eightSixDoubleZero.summoningScepters.common.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class SummonedZombie extends ZombieEntity {
    public SummonedZombie(EntityType<? extends ZombieEntity> type, World worldIn) {
        super(type, worldIn);
    }

    private static final Predicate<LivingEntity> SUMMONS = (p_213797_0_) -> {
        return p_213797_0_.getEntity().getClass() != SummonedZombie.class && p_213797_0_.getEntity().getClass() != SummonedWitherSkeleton.class
                && p_213797_0_.getEntity().getClass() != SummonedSkeleton.class && p_213797_0_.getEntity().getClass() != SummonedHorse.class
                && p_213797_0_.getEntity().getClass() != SummonedStray.class;

    }; ///Also see Wither Class if more information is needed.


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.addBehaviourGoals();
    }

    @Override
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new RestrictSunGoal(this));
        this.goalSelector.addGoal(4, new FleeSunGoal(this, 1.2d));
        this.goalSelector.addGoal(1, new ZombieAttackGoal(this, 1.0d, false));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, 0, false, false, SUMMONS));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, SlimeEntity.class, true));
    }

    public void Berzerk()
    {
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.45f));
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
