package com.kataer.mall.demo.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.TermVector;

import java.io.Serializable;

@Data
@Document(indexName = "goods")
public class BookDoc implements Serializable {
  @Id
  private Long id;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String title;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String author;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String publisher;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String category;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String content;
  @Field(type = FieldType.Text, analyzer = "ik_smart", termVector = TermVector.yes)
  private String directory;
  private Integer price;
}
