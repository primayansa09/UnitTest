package com.example.academy.ui.academy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.academy.R;
import com.example.academy.databinding.ItemAcademyBinding;
import com.example.academy.ui.data.CourseEntity;
import com.example.academy.ui.detail.DetailCourseActivity;

import java.util.ArrayList;
import java.util.List;

public class AcademyAdapter extends RecyclerView.Adapter<AcademyAdapter.CourseViewHolder> {
    private final List<CourseEntity> listCourses = new ArrayList<>();

    public void setCourses(List<CourseEntity> listCourses){
        if (listCourses == null) return;
        this.listCourses.clear();
        this.listCourses.addAll(listCourses);
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAcademyBinding binding = ItemAcademyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        CourseEntity course = listCourses.get(position);
        holder.bind(course);

    }

    @Override
    public int getItemCount() {
        return listCourses.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        private final ItemAcademyBinding binding;

        public CourseViewHolder(ItemAcademyBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(CourseEntity course){
            binding.tvItemTitle.setText(course.getTitle());
            binding.tvItemDate.setText(itemView.getResources().getString(R.string.deadline_date, course.getDeadline()));
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailCourseActivity.class);
                intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.getCourseId());
                itemView.getContext().startActivity(intent);
            });

            Glide.with(itemView.getContext())
                    .load(course.getImagepath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}
