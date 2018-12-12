package com.example.android.newsfeed1;

public class News {

    private String mHeadline;

    private String mSection;

    private String mPublicationDate;

    private String mUrl;

    public News(String headline, String section, String publicationDate, String url){
        mHeadline = headline;
        mSection = section;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    public String getHeadline(){
        return mHeadline;
    }

    public String getSection(){
        return mSection;
    }

    public String getPublicationDate() {
        return mPublicationDate;
    }

    public String getUrl(){
        return mUrl;
    }
}
