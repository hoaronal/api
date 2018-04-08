package com.app.vn.common.support;

import java.util.Map;

public class MailObject {

    private String from;
    private String[] to;
    private String subject;
    private String content;
    private Map model;
    public MailObject() {
    }

    public MailObject(String from, String[] to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map getModel() {
        return model;
    }

    public void setModel(Map model) {
        this.model = model;
    }
}
