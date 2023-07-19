package ru.job4j.toone;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
public class ItemManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "participates",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participates = new ArrayList<>();
}
