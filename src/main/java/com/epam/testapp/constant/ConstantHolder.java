package com.epam.testapp.constant;

public class ConstantHolder {

    public static final String SUCCESS = "success";
    public static final String ID = "id";
    public static final String NEWS_ATTRIBUTE = "news";
    public static final String LOCALE_ATTRIBUTE = "locale";
    public static final String REFERRER = "referer";

    public static final String SHOW_LIST_SUCCESS = "show_list_success";
    public static final String SHOW_ADD_FORM_SUCCESS = "show_add_form_success";
    public static final String SHOW_NEWS_VIEW_SUCCESS = "show_news_view_success";
    public static final String DELETE_NEWS_SUCCESS = "delete_news_success";

    public static final String FIND_ALL_NEWS_NAMED_QUERY = "News.findAll";
    public static final String SAVE_NEWS_NAMED_QUERY = "News.saveNews";
    public static final String UPDATE_NEWS_NAMED_QUERY = "News.updateNews";
    public static final String FIND_NEWS_BY_ID_NAMED_QUERY = "News.findById";
    public static final String DELETE_NEWS_BY_ID_NAMED_QUERY = "News.deleteById";
    public static final String DELETE_NEWS_LIST_NAMED_QUERY = "News.deleteList";
    public static final String GET_LAST_INSERTED_ID_QUERY = "SELECT NEWS_SEQ.currval FROM dual";

    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String BRIEF = "brief";
    public static final String CONTENT = "content";

    public static final String ID_LIST = "ids";

    private ConstantHolder() {
    }

}
