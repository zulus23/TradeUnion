package ru.zhukov.tradeunion.member;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gtk_TU_ViewMembers")

@Data
@EqualsAndHashCode(of = {"id"})
public class Member {
    @Id
    private String id;
    @Column(name = "DbName")
    private String enterprise;
    @Column(name = "Fio")
    private String fio;
    @Column(name = "Department")
    private String department;


}
