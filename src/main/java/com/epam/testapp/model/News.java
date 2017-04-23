package com.epam.testapp.model;

import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news")
public class News extends BaseEntity implements Serializable {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("News");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Transient
    private String strDate;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    public News() {
    }

    public News(long newsId) {

        this.id = newsId;
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
