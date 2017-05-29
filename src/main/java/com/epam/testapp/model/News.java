package com.epam.testapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

import static com.epam.testapp.constant.ConstantHolder.*;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_EMPTY)
@NamedQueries({
        @NamedQuery(name = FIND_ALL_NEWS_NAMED_QUERY, query = "from News order by date desc"),
        @NamedQuery(name = FIND_NEWS_BY_ID_NAMED_QUERY, query = "from News n where n.id=:id"),
        @NamedQuery(name = DELETE_NEWS_BY_ID_NAMED_QUERY, query = "delete from News n where n.id=:id"),
        @NamedQuery(name = DELETE_NEWS_LIST_NAMED_QUERY, query = "delete from News n where n.id in :ids")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = SAVE_NEWS_NAMED_QUERY, query = "INSERT INTO NEWS (ID, TITLE, DATETIME, BRIEF, CONTENT) " +
                "VALUES (NEWS_SEQ.nextval, :title, :date, :brief, :content)"),
        @NamedNativeQuery(name = UPDATE_NEWS_NAMED_QUERY, query = "UPDATE NEWS SET TITLE=:title, DATETIME=:date, " +
                "BRIEF=:brief, CONTENT=:content WHERE ID=:id")
})
@XmlRootElement(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "News", propOrder = {"id", "title", "date", "brief", "content"})
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ")
    @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "NEWS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATETIME")
    private Date date = new Date();

    @Transient
    @XmlTransient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String strDate;

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTENT")
    private String content;

    public News() {
    }

    public News(long newsId) {

        this.id = newsId;
    }

    public News(String title, Date date, String brief, String content) {

        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }

    public News(long id, String title, Date date, String brief, String content) {

        this.id = id;
        this.title = title;
        this.date = date;
        this.brief = brief;
        this.content = content;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (!title.equals(news.title)) return false;
        if (!date.equals(news.date)) return false;
        if (!brief.equals(news.brief)) return false;
        return content.equals(news.content);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
