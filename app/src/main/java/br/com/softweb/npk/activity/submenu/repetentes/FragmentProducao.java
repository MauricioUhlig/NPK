package br.com.softweb.npk.activity.submenu.repetentes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.softweb.npk.R;

/**
 * Created by User on 24/12/2016.
 */

public class FragmentProducao extends Fragment {
    public FragmentProducao(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producao_abacate, container, false);
    }
}


