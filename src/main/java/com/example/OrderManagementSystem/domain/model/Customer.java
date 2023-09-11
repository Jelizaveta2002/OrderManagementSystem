package com.example.OrderManagementSystem.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "registration_code")
    private String registrationCode;

    @Column(name = "full_name")
    @NotNull
    private String fullName;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "telephone")
    @NotNull
    private String telephone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    protected List<Order> orders = new ArrayList<>();
}
