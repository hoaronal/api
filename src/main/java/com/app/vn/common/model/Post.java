package com.app.vn.common.model;
/*
 * Copyright 2014 Tagbangers, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.hibernate.annotations.*;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "post", uniqueConstraints = @UniqueConstraint(columnNames = {"code", "language"}))
@DynamicInsert
@DynamicUpdate
public class Post extends DomainObject<Long>  {

    public static final String SHALLOW_GRAPH_NAME = "POST_SHALLOW_GRAPH";
    public static final String DEEP_GRAPH_NAME = "POST_DEEP_GRAPH";

    public enum Status {
        DRAFT, SCHEDULED, PUBLISHED
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "code",length = 200)
    private String code;

    @Column(name = "language",length = 3, nullable = false)
    private String language = "vi";

    @Column(name = "status",length = 50, nullable = false)
    private String status;

    @Column(name = "date",length = 6)
    private LocalDateTime date;

    @Column(name = "title",length = 200)
    private String title;

    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cover_id")
    private Media cover;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drafted_id")
    private Post drafted;

    @Column(name = "drafted_code",length = 200)
    private String draftedCode;

    @Column(name = "seo_title",length = 500)
    private String seoTitle;

    @Column(name = "seo_description")
    private String seoDescription;

    @Column(name = "seo_keywords")
    private String seoKeywords;

    @Column(name = "views")
    private long views;

    public Post(String code, String language, String status, LocalDateTime date, String title, String body, Media cover, User author, Post drafted, String draftedCode, String seoTitle, String seoDescription, String seoKeywords, long views) {
        this.code = code;
        this.language = language;
        this.status = status;
        this.date = date;
        this.title = title;
        this.body = body;
        this.cover = cover;
        this.author = author;
        this.drafted = drafted;
        this.draftedCode = draftedCode;
        this.seoTitle = seoTitle;
        this.seoDescription = seoDescription;
        this.seoKeywords = seoKeywords;
        this.views = views;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Media getCover() {
        return cover;
    }

    public void setCover(Media cover) {
        this.cover = cover;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getDrafted() {
        return drafted;
    }

    public void setDrafted(Post drafted) {
        this.drafted = drafted;
    }

    public String getDraftedCode() {
        return draftedCode;
    }

    public void setDraftedCode(String draftedCode) {
        this.draftedCode = draftedCode;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }
}
