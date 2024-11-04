package org.kataew.newsapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;


    public final static Role USER_ROLE = new Role(1L, "user");
    public final static Role ADMIN_ROLE = new Role(2L, "admin");

}