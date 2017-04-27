package com.epam.testapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "findAll", query = "from News order by date desc ")})
@NamedNativeQueries(
        @NamedNativeQuery(name = "saveNews", query = "INSERT INTO MYDB.NEWS (ID, TITLE, DATETIME, BRIEF, CONTENT) " +
                "VALUES (MYDB.NEWS_SEQ.nextval, :title, :date, :brief, :content)"))
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
    private Time datetime;

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

    public Time getDatetime() {
        return datetime;
    }

    public void setDatetime(Time datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (brief != null ? !brief.equals(news.brief) : news.brief != null) return false;
        if (content != null ? !content.equals(news.content) : news.content != null) return false;
        if (datetime != null ? !datetime.equals(news.datetime) : news.datetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
