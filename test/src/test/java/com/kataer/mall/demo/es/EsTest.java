package com.kataer.mall.demo.es;

import com.kataer.mall.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class EsTest {
  @Autowired
  private BookDocMapper bookDocMapper;

  @Test
  public void saveDoc() {
    BookDoc bookDoc = new BookDoc();
    bookDoc.setTitle("鬼吹灯");
    bookDoc.setAuthor("天下霸唱");
    bookDoc.setCategory("冒险");
    bookDoc.setContent("《鬼吹灯》的故事情节围绕一本家传的秘书残卷展开");
    bookDoc.setPublisher("工业出版社");
    bookDoc.setDirectory("白纸人和鼠友");
    bookDoc.setPrice(8999);
    BookDoc save = bookDocMapper.save(bookDoc);
  }
}
