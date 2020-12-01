package com.example.bulletin_zby;

import java.util.List;

public class info {

        private String id;
        private String title;
        private String author;
        private String publishTime;
        private Integer type;
        private String cover;
        private String conver;
        private List<String> covers;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getConver() {
            return conver;
        }

        public void setConver(String conver) {
            this.conver = conver;
        }

        public List<String> getCovers() {
            return covers;
        }

        public void setCovers(List<String> covers) {
            this.covers = covers;
        }
}


