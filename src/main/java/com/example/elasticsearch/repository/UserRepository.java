package com.example.elasticsearch.repository;

import com.example.elasticsearch.entities.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,Integer> {
    //@Query("{\"bool\": {\"should\": [{\"match\": {\"name\": \"?0\"}}, {\"match\": {\"gender\": \"?1\"}}]}}")
    public List<User> findByNameLikeOrGenderLike(String name, String gender);
}
