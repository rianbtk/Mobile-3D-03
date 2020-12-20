package com.rianbtk.sisteminfosetting.ui.cara_rooting;

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

import com.rianbtk.sisteminfosetting.databinding.FragmentCaraRootingBinding;
import com.rianbtk.sisteminfosetting.databinding.FragmentCaraRootingBinding;

public class CaraRootingFragment extends Fragment {

    private CaraRootingViewModel caraRootingViewModel;
    private FragmentCaraRootingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        caraRootingViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CaraRootingViewModel.class);

        binding = FragmentCaraRootingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCaraRooting;
        caraRootingViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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