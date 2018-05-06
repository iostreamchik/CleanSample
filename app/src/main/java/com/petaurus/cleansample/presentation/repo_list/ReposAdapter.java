package com.petaurus.cleansample.presentation.repo_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.petaurus.cleansample.R;

import java.util.ArrayList;
import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.BaseViewHolder> {

    private static final String TAG = ReposAdapter.class.getSimpleName();

    public static final int TYPE_REPO = 0;

    private ArrayList<RepoItem> items;
    private OnEventListener listener;

    public interface OnEventListener {
        void onClick(int position, RepoItem item);
        void onItemsSizeChange(boolean isEmpty);
    }

    public ReposAdapter(@NonNull OnEventListener listener) {
        this.listener = listener;
        items = new ArrayList<>(0);
    }

    @SuppressWarnings("unchecked")
    public void setItems(List<? extends RepoItem> items) {
        if (items == null)
            return;
        this.items = (ArrayList<RepoItem>) items;
        notifyDataSetChanged();
        onItemsSizeChange();
    }

    private void onItemsSizeChange() {
        listener.onItemsSizeChange(items.size() == 0);
    }

    @Override
    public int getItemViewType(int position) {
        RepoItem item = items.get(position);
        return TYPE_REPO;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder;
        if (viewType == TYPE_REPO) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_repo, parent, false);
            viewHolder = new ReposViewHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_repo, parent, false);
            viewHolder = new ReposViewHolder(itemView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        RepoItem item = items.get(position);
        holder.root.setOnClickListener(v -> {
            Log.d(TAG, "onClick: " + item);
            listener.onClick(position, item);
        });
        int viewType = getItemViewType(position);

        if (viewType == TYPE_REPO) {
            final ReposViewHolder viewHolder = (ReposViewHolder) holder;
            /*Name*/
            viewHolder.tvName.setText(item.getName());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class ReposViewHolder extends BaseViewHolder {

        private final RepoItemBinding binding;

        TextView tvName;

        ReposViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
        }
    }

    abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        View root;
        BaseViewHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.v_root);
        }
    }
}
