package com.example.academy.ui.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academy.R;
import com.example.academy.databinding.ItemsModuleLisBinding;
import com.example.academy.ui.data.ModuleEntity;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseAdapter extends RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder> {

    private final List<ModuleEntity> listModule = new ArrayList<>();

    public void setModule(List<ModuleEntity> modules){
        if (modules == null) return;
        listModule.clear();
        listModule.addAll(modules);
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsModuleLisBinding binding = ItemsModuleLisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ModuleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder viewHolder, int position) {
        ModuleEntity module = listModule.get(position);
        viewHolder.bind(module);
    }

    @Override
    public int getItemCount() {
        return listModule.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {

        private final ItemsModuleLisBinding binding;

        public ModuleViewHolder(ItemsModuleLisBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ModuleEntity module){
            binding.textModuleTitle.setText(module.getmTitle());
        }
    }
}
