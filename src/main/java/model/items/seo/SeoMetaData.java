package model.items.seo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import model.items.Item;

import javax.persistence.*;

@Entity
@Table(name = "seo_meta_data")
//@SequenceGenerator(name = "my_seq_gen", sequenceName = "seo_meta_data_seq", allocationSize = 1, initialValue = AbstractBaseEntity.START_SEQ)
public class SeoMetaData {

    @Id
    @Column(name = "id")
    protected Integer id;

    @OneToOne (mappedBy = "seoMetaData", cascade = CascadeType.ALL)
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id")
    private Item item;

    @Column(name = "title")
    private String title;


    @Column(name = "keywords")
    private String keywords;

    @Column(name = "description")
    private String description;

    public SeoMetaData(){

    }

    public SeoMetaData(Integer id, String title, String keywords, String description) {

        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
    }

    public SeoMetaData(Integer id, Item item, String title, String keywords, String description) {

        this.id = id;
        this.item = item;
        this.title = title;
        this.keywords = keywords;
        this.description = description;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        this.id = item.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
