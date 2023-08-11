package com.trodev.dailytodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.dailytodo.databinding.EachRvBinding;

public class RVAdapter extends ListAdapter<Note, RVAdapter.ViewHolder> {

    public RVAdapter() {
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDisp().equals(newItem.getDisp());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Note note = getItem(position);
        holder.binding.titleRv.setText("Title: "+note.getTitle());
        holder.binding.dispRv.setText(note.getDisp());

        /*notes animation*/
        holder.binding.cardview.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.slider));
    }

    public Note getNote(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /*view binding*/
        EachRvBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*binding*/
            binding = EachRvBinding.bind(itemView);
        }
    }
}
