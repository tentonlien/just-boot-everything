package just.boot.elasticsearch.controller;

import just.boot.elasticsearch.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tenton Lien
 */
@RestController
@RequestMapping("/api/just/boot/elasticsearch")
public class TestController {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @PostMapping
    public String save(@RequestBody Article article) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(article.getId())
                .withObject(article)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery);
        return documentId;
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable("id")  Long id) {
        Article article = elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Article.class);
        return article;
    }


}
