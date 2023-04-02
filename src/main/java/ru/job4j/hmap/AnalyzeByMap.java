package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0D;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                result += subject.score();
                counter++;
            }
        }
        result = result / counter;
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            int counter = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                counter++;
            }
            result.add(new Label(pupil.name(), score / counter));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.put(subject.name(), scoreBySubject.get(subject.name()) == null ? subject.score() :
                        scoreBySubject.get(subject.name()) + subject.score());
            }
        }
        for (Map.Entry<String, Double> entry : scoreBySubject.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0D;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            result.add(new Label(pupil.name(), score));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Double> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySubject.put(subject.name(), scoreBySubject.get(subject.name()) == null ? subject.score() :
                        scoreBySubject.get(subject.name()) + subject.score());
            }
        }
        for (Map.Entry<String, Double> entry : scoreBySubject.entrySet()) {
            result.add(new Label(entry.getKey(), entry.getValue()));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
