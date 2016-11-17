package com.platformer.model.character.state;

import com.platformer.model.character.Character;

public abstract class CharacterState {

    public abstract void grounded(Character character);

    public abstract void jump(Character character);

    public abstract void stopJump(Character character);

    public abstract void falling(Character character);
}
