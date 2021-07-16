package com.Relation.SpringJpaRelation.Songs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

//    List<Song> findAllById(Long id);
}
