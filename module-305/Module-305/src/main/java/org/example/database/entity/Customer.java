package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Customer {

    // the Id annotation tells hibernate that this is the primary key for the entity
    @Id
    // this tells hibernate that the database will autoincrement the new ID for a new record in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // this defines the database column
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastname;
    @Column(name = "contact_firstname")
    private String contactFirstname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address_line1")
    private String address_line1;
    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "sales_rep_employee_id")
    private int salesRepEmployeeId;
    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private double creditLimit;
}