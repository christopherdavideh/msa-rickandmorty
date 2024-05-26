package com.cdeh.msa.rickandmorty.repository;

import com.cdeh.msa.rickandmorty.domain.cache.CharactersCacheDto;
import org.springframework.data.repository.CrudRepository;

public interface CharactersCacheRepository extends CrudRepository<CharactersCacheDto, String> {

}
