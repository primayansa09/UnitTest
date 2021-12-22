package com.example.academy.ui.academy;

import androidx.lifecycle.ViewModel;

import com.example.academy.ui.data.CourseEntity;
import com.example.academy.ui.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {
    public List<CourseEntity> getCourses(){
        return DataDummy.generateDummyCourses();
    }
}
