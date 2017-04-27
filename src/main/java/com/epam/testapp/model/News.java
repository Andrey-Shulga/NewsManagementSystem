package com.epam.testapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "News.findAll", query = "from News order by date desc"),
        @NamedQuery(name = "News.findById", query = "from News n where n.id=:id"),
        @NamedQuery(name = "News.deleteById", query = "delete from News n where n.id=:id"),
        @NamedQuery(name = "News.deleteList", query = "delete from News n where n.id in :ids")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "News.saveNews", query = "INSERT INTO MYDB.NEWS (ID, TITLE, DATETIME, BRIEF, CONTENT) " +
                "VALUES (MYDB.NEWS_SEQ.nextval, :title, :date, :brief, :content)"),
        @NamedNativeQuery(name = "News.updateNews", query = "UPDATE MYDB.NEWS SET TITLE=:title, DATETIME=:date, " +
                "BRIEF=:brief, CONTENT=:content WHERE ID=:id")
})
@Entity
@Table(name = "NEWS", schema = "MYDB")
public class News extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NEWS_SEQ")
    @SequenceGenerator(name = "NEWS_SEQ", sequenceName = "MYDB.NEWS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATETIME")
    private Date date;

    @Transient
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
