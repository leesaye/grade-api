package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        float total_grades = 0.0f;
        String[] members = gradeDB.getMyTeam().getMembers();

        for (int i = 0; i < members.length; i++) {
            total_grades += gradeDB.getGrade(members[i], course).getGrade();
        }

        return total_grades/members.length;
    }
}
