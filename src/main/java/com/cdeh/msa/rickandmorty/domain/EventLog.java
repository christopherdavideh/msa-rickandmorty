package com.cdeh.msa.rickandmorty.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EventLog {
    private String eventType;
    private Object data;
}
