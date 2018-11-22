package com.phamngoclinh.loginfbfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Historyfragment extends Fragment {
    private View layoutHistory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutHistory = inflater.inflate(R.layout.fragment_history,container,false);
        return layoutHistory;
    }
}
