package ru.zhukov.tradeunion.member;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Gtk_Pf_ViewMembers")

@Data
@EqualsAndHashCode(of = {"id"})
public class Member {
    @Id
    @Column(name = "pers_id")
    private String id;
    @Column(name = "DbName")
    private String enterprise;
    @Column(name = "Fio")
    private String fio;
    @Column(name = "Department")
    private String department;


}
