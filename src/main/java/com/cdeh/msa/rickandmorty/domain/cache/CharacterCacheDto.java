package com.cdeh.msa.rickandmorty.domain.cache;

import com.cdeh.msa.rickandmorty.service.dto.Character;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@RedisHash("characters")
public class CharacterCacheDto {
    @Id
    String id;
    List<Character> characters;
    @TimeToLive
    Long ttl;

}
