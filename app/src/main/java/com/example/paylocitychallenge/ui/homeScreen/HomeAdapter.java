package com.example.paylocitychallenge.ui.homeScreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.paylocitychallenge.databinding.CardAddedEmployeeBinding;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<EmployeeCard> mEmployeeList;

    HomeAdapter(ArrayList<EmployeeCard> employeeList) { mEmployeeList = employeeList; }

    static class HomeViewHolder extends RecyclerView.ViewHolder {

        private CardAddedEmployeeBinding mBinding;

        HomeViewHolder(CardAddedEmployeeBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        void bind(EmployeeCard employeeCard) {
            mBinding.setEmployeeData(employeeCard);
            mBinding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CardAddedEmployeeBinding itemBinding = CardAddedEmployeeBinding.inflate(layoutInflater,
                parent, false);
        return new HomeViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        EmployeeCard employeeCard = mEmployeeList.get(position);
        holder.bind(employeeCard);
    }

    @Override
    public int getItemCount() { return mEmployeeList != null ? mEmployeeList.size() : 0; }
}
