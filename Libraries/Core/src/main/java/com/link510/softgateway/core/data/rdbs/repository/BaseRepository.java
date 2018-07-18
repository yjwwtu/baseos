package com.link510.softgateway.core.data.rdbs.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;


@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable>
     extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {

}
