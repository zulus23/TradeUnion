package ru.zhukov.tradeunion.member;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gtk_Pf_ViewMembers")

@Data
@EqualsAndHashCode(of = {"id"})
public class Member {
    @Id
    private String id;
    private String enterprise;
    private String firstName; // имя
    private String surName;   // фамилия
    private String middleName;// отчество
    private String department;

}
