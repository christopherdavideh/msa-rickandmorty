package com.cdeh.msa.rickandmorty.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {
    InfoDTO info;
    List<Character> results;
}
