package com.example.academy.ui.bookmark;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.academy.R;
import com.example.academy.databinding.ItemsBookmarkBinding;
import com.example.academy.ui.bookmark.BookmarkFragmentCallback;
import com.example.academy.ui.data.CourseEntity;
import com.example.academy.ui.detail.DetailCourseActivity;

import java.util.ArrayList;
import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.CourseViewHolder> {

    private final BookmarkFragmentCallback callback;
    private final ArrayList<CourseEntity> listCourses = new ArrayList<>();

    BookmarkAdapter(BookmarkFragmentCallback callback){
        this.callback = callback;
    }

    public void setCourses(List<CourseEntity> courses){
        if (courses == null) return;
        this.listCourses.clear();
        this.listCourses.addAll(courses);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsBookmarkBinding binding = ItemsBookmarkBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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

        private final ItemsBookmarkBinding binding;

        public CourseViewHolder(ItemsBookmarkBinding binding) {
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
            binding.imgShare.setOnClickListener(view -> callback.onShareClick(course));
            Glide.with(itemView.getContext())
                    .load(course.getImagepath())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgPoster);
        }
    }
}
