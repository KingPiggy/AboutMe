package com.hoondragonite.aboutme.domain.user;

import com.hoondragonite.aboutme.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uID;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email; // login email
    @Column
    private String picture;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;  // Role: 직접 만드는 클래스

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}