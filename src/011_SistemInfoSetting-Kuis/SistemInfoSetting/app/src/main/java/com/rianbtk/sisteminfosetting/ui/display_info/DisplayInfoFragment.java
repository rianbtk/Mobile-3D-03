package com.rianbtk.sisteminfosetting.ui.display_info;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rianbtk.sisteminfosetting.databinding.FragmentDisplayInfoBinding;

public class DisplayInfoFragment extends Fragment {

    private DisplayInfoViewModel displayInfoViewModel;
    private FragmentDisplayInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        displayInfoViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DisplayInfoViewModel.class);

        binding = FragmentDisplayInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDisplayInfo;
        displayInfoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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