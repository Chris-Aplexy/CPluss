package com.company.cpluss.model.userInfo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true, nullable = false, updatable = false)
    private String username;
    @NotNull
    private String password;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @Nullable
    private List<Role> roles;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Address.class)
    private List<Address> addresses;

}
