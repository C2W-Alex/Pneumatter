package pneumatter.rituals;

public interface IRitualBase {

    EnumRitualLevel getLevel();

    void applySideEffects();

    void applyEffects();

    void castSpell();

}
