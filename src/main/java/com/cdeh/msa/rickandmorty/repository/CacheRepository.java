package com.cdeh.msa.rickandmorty.repository;

import com.cdeh.msa.rickandmorty.domain.cache.CharacterCacheDto;
import org.springframework.data.repository.CrudRepository;

public interface CacheRepository extends CrudRepository<CharacterCacheDto, String> {

}
