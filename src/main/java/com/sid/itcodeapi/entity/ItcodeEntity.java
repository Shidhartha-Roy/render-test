package com.sid.itcodeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "code_search")
public class ItcodeEntity {

    @Id
    private String id;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    private String doclink;

    private String applicable;
}
