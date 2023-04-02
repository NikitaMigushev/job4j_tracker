package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("X job", 0),
                new Job("A job", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpAscName = new JobAscByPriority();
        int rsl = cmpAscName.compare(
                new Job("X job", 0),
                new Job("A job", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpAscName = new JobDescByName();
        int rsl = cmpAscName.compare(
                new Job("X job", 0),
                new Job("A job", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpAscName = new JobDescByPriority();
        int rsl = cmpAscName.compare(
                new Job("X job", 2),
                new Job("A job", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}