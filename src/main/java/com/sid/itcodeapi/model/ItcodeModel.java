package com.sid.itcodeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItcodeModel {

    private String id;

    private String description;

    private String doclink;

    private String applicable;
}
