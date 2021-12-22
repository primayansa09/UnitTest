package com.example.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.example.academy.ui.data.CourseEntity;
import com.example.academy.ui.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    public List<CourseEntity> getBookmarks(){
        return DataDummy.generateDummyCourses();
    }
}
