package com.cdeh.msa.rickandmorty.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoDTO {

    Integer count;
    Integer pages;
    String  next;
    String  prev;
}
