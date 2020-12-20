package com.rianbtk.sisteminfosetting.ui.baterai_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;

import com.rianbtk.sisteminfosetting.databinding.FragmentBateraiInfoBinding;
import com.rianbtk.sisteminfosetting.databinding.FragmentBateraiInfoBinding;

public class BatraiInfoFragment extends Fragment {

    private BateraiInfoViewModel bateraiInfoViewModel;
    private FragmentBateraiInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bateraiInfoViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(BateraiInfoViewModel.class);

        binding = FragmentBateraiInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        bateraiInfoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}