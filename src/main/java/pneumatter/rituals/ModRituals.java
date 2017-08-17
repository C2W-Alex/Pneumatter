package pneumatter.rituals;

public class ModRituals {

    public static RitualCommitment ritualCommitment;
    public static RitualCurse ritualCurse;

    public static void register(){
        ritualCommitment = new RitualCommitment();
        ritualCurse = new RitualCurse();
    }
}
