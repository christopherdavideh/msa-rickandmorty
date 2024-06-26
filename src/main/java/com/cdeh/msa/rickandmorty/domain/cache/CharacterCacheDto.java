package com.cdeh.msa.rickandmorty.domain.cache;

import com.cdeh.msa.rickandmorty.service.dto.Character;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@RedisHash("character")
public class CharacterCacheDto {
    @Id
    String id;
    Character character;
    @TimeToLive
    Long ttl;

}
