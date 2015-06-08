package net.logcat.binding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.logcat.binding.api.models.Repo;
import net.logcat.binding.databinding.GithubRepoItemBinding;

import java.util.List;

public class GithubReposAdapter extends RecyclerView.Adapter<GithubReposAdapter.ViewHolder> {

    private final List<Repo> githubRepos;

    public GithubReposAdapter(List<Repo> githubRepos) {
        this.githubRepos = githubRepos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        GithubRepoItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.github_repo_item, null, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.binding.setRepo(githubRepos.get(i));
    }

    @Override
    public int getItemCount() {
        return githubRepos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final GithubRepoItemBinding binding;

        public ViewHolder(GithubRepoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
