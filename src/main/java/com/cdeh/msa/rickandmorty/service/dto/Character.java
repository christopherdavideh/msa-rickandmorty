package com.cdeh.msa.rickandmorty.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Character {
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}
