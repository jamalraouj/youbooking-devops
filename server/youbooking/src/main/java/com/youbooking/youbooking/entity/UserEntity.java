package com.youbooking.youbooking.entity;

import com.youbooking.youbooking.classes.Message;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    private String password;
    private String email;
    private boolean isActive;
    private Role role;

    public UserEntity(String email ,String password, boolean isActive, Role role) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public UserEntity(String name, String lastName, String email, String password, boolean isActive, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.isActive = isActive;
        this.role = role;
    }

    @Transient
    private Message message;
}
