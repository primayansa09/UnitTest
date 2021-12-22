package com.example.academy.ui.reader.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academy.databinding.ItemsModuleListCustomBinding;
import com.example.academy.ui.data.ModuleEntity;

import java.util.ArrayList;
import java.util.List;

public class ModuleListAdapter extends RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder> {

    private final MyAdapterClickListener listener;
    private final List<ModuleEntity> listModules = new ArrayList<>();

    ModuleListAdapter(MyAdapterClickListener listener){
        this.listener = listener;
    }

    public void setModules(List<ModuleEntity> listModules){
        if (listModules == null) return;
        this.listModules.clear();
        this.listModules.addAll(listModules);
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsModuleListCustomBinding binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ModuleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder viewHolder, int position) {
        ModuleEntity module = listModules.get(position);
        viewHolder.bind(module);
        viewHolder.itemView.setOnClickListener(view -> {
            listener.onItemClicked(viewHolder.getAdapterPosition(), listModules.get(viewHolder.getAdapterPosition()).getmModuleId());
        });

    }

    @Override
    public int getItemCount() {
        return listModules.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder {

        private final ItemsModuleListCustomBinding binding;

        public ModuleViewHolder(ItemsModuleListCustomBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(ModuleEntity module){
            binding.textModuleTitle.setText(module.getmTitle());
        }
    }

    interface MyAdapterClickListener{
        void onItemClicked(int position, String moduleId);
    }
}
