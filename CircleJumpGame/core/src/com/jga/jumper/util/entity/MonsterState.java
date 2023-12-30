package com.jga.jumper.util.entity;

public enum MonsterState {
    WALKING,
    JUMPING,
    FALLING;

    //public methods
    public boolean isWalking(){
        return this==WALKING;
    }

    public boolean isJumping(){
        return this==JUMPING;
    }

    public boolean isFalling(){
        return this==FALLING;
    }





}
