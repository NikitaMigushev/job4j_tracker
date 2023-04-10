package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Method transforms list of profiles into list of addresses.
     *
     * @param profiles
     * @return list of addresses.
     */
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Method transforms list of profiles into list of addresses without
     * @param profiles
     * @return
     */
    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(new ProfileAscByAddress())
                .distinct()
                .collect(Collectors.toList());
    }
}


