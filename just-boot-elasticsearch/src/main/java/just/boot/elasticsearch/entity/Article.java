package just.boot.elasticsearch.entity;

import lombok.Data;

/**
 * @author Tenton Lien
 */
@Data
public class Article {
    private String id;
    private String title;
    private String author;
    private String content;
}
