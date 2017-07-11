package com.example.agterra.jdrnaheulbeuk;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * Created by Agterra on 11/07/2017.
 */

public class CharacterFinderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.character_finder_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        final Button rollStatsButton = (Button)getView().findViewById(R.id.rollButton);

        rollStatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rollStats(view);

            }
        });

    }

    public void rollStats(View view)
    {

        Random random = new Random();

        EditText courageEditText = getView().findViewById(R.id.courageText);

        courageEditText.setText(String.valueOf(7+(random.nextInt(6))+1));

        EditText intelligenceText = getView().findViewById(R.id.intelligenceText);

        intelligenceText.setText(String.valueOf(7+(random.nextInt(6))+1));

        EditText charismeText = getView().findViewById(R.id.charismeText);

        charismeText.setText(String.valueOf(7+(random.nextInt(6))+1));

        EditText adresseText = getView().findViewById(R.id.adresseText);

        adresseText.setText(String.valueOf(7+(random.nextInt(6))+1));

        EditText forceText = getView().findViewById(R.id.forceText);

        forceText.setText(String.valueOf(7+(random.nextInt(6))+1));

    }

}
