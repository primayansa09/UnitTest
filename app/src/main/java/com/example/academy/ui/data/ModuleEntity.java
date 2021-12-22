package com.example.academy.ui.data;

import com.example.academy.ui.data.ContentEntity;

public class ModuleEntity {
    public ContentEntity contentEntity;
    private String mModuleId;
    private String mCourseId;
    private String mTitle;
    private Integer mPosition;
    private boolean mRead = false;

    public ModuleEntity(String moduleId, String courseId, String title, Integer position, Boolean read){
        this.mModuleId = moduleId;
        this.mCourseId = courseId;
        this.mTitle = title;
        this.mPosition = position;

        if (read != null){
            this.mRead = read;
        }
    }

    public ContentEntity getContentEntity() {
        return contentEntity;
    }

    public void setContentEntity(ContentEntity contentEntity) {
        this.contentEntity = contentEntity;
    }

    public String getmModuleId() {
        return mModuleId;
    }

    public void setmModuleId(String mModuleId) {
        this.mModuleId = mModuleId;
    }

    public String getmCourseId() {
        return mCourseId;
    }

    public void setmCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Integer getmPosition() {
        return mPosition;
    }

    public void setmPosition(Integer mPosition) {
        this.mPosition = mPosition;
    }

    public boolean ismRead() {
        return mRead;
    }

    public void setmRead(boolean mRead) {
        this.mRead = mRead;
    }
}
