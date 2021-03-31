package com.kataer.mall.demo.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookDocMapper extends ElasticsearchRepository<BookDoc, Long> {
}
