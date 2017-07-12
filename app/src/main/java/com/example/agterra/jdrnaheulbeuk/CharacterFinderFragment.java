package com.example.agterra.jdrnaheulbeuk;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Agterra on 11/07/2017.
 */

public class CharacterFinderFragment extends Fragment {

    private Player player;

    private String race, metier;

    private int courage, intel, charisme, adresse, force, magicResistance, physicalResistance, lifePoint, otherEnergy, attack, parade;

    private EditText attackText, paradeText, raceText, metierText, courageText, intelText, charismeText, adressText, forceText, magicResistanceText, physicalResistanceText, lifePointText, otherEnergyText;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.character_finder_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

       // final Button rollStatsButton = (Button)getView().findViewById(R.id.rollButton);

        final Button validateButton = getView().findViewById(R.id.validateButton);

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validateButtonAction(view);

            }
        });

        this.raceText = getView().findViewById(R.id.raceText);

        this.metierText = getView().findViewById(R.id.metierText);

        this.courageText = getView().findViewById(R.id.courageText);

        this.intelText = getView().findViewById(R.id.intelligenceText);

        this.charismeText = getView().findViewById(R.id.charismeText);

        this.adressText = getView().findViewById(R.id.adresseText);

        this.forceText = getView().findViewById(R.id.forceText);

        this.magicResistanceText = getView().findViewById(R.id.magicResistanceText);

        this.physicalResistanceText = getView().findViewById(R.id.piercingResistanceText);

        this.lifePointText = getView().findViewById(R.id.lifePointText);

        this.otherEnergyText = getView().findViewById(R.id.otherEnergyText);

        this.attackText = getView().findViewById(R.id.attackText);

        this.paradeText = getView().findViewById(R.id.paradeText);

        Player player = loadPlayer();

        if(player != null) {

            courageText.setText(String.valueOf(player.getCourage()));

            this.courage = player.getCourage();

            intelText.setText(String.valueOf(player.getIntelligence()));

            this.intel = player.getIntelligence();

            charismeText.setText(String.valueOf(player.getCharisma()));

            this.charisme = player.getCharisma();

            adressText.setText(String.valueOf(player.getAdress()));

            this.adresse = player.getAdress();

            forceText.setText(String.valueOf(player.getForce()));

            this.force = player.getForce();

            magicResistanceText.setText(String.valueOf(player.getMagicResistance()));

            this.magicResistance = player.getMagicResistance();

            physicalResistanceText.setText(String.valueOf(player.getPierceResistance()));

            this.physicalResistance = player.getPierceResistance();

            lifePointText.setText(String.valueOf(player.getLifePoints()));

            this.lifePoint = player.getLifePoints();

            otherEnergyText.setText(String.valueOf(player.getOtherEnergy()));

            this.otherEnergy = player.getOtherEnergy();

            raceText.setText(player.getRace());

            this.race = player.getRace();

            metierText.setText(player.getMetier());

            this.metier = player.getMetier();

            attackText.setText(String.valueOf(player.getAttack()));

            this.attack = player.getAttack();

            paradeText.setText(String.valueOf(player.getParade()));

            this.parade = player.getParade();

        }

    }

    public void validateButtonAction(View view)
    {

        if(checkAllFields() == false) {

            Toast.makeText(getActivity(), "Remplissez tous les champs !", Toast.LENGTH_SHORT).show();

            return;

        }

        Button validateButton = (Button)view;

        this.courage = Integer.parseInt(courageText.getText().toString());

        this.intel = Integer.parseInt(intelText.getText().toString());

        this.force = Integer.parseInt(forceText.getText().toString());

        this.charisme = Integer.parseInt(charismeText.getText().toString());

        this.adresse = Integer.parseInt(adressText.getText().toString());

        this.magicResistance = (int)Math.ceil((this.courage + this.intel + this.force)/3);

        this.physicalResistance = Integer.parseInt(physicalResistanceText.getText().toString());

        this.lifePoint = Integer.parseInt(lifePointText.getText().toString());

        this.otherEnergy = Integer.parseInt(otherEnergyText.getText().toString());

        this.race = raceText.getText().toString();

        this.metier = metierText.getText().toString();

        this.attack = Integer.parseInt(attackText.getText().toString());

        this.parade = Integer.parseInt(paradeText.getText().toString());

        Player player = new Player(this.courage, this.intel, this.charisme, this.adresse, this.force);

        player.setMagicResistance(this.magicResistance);

        magicResistanceText.setText(String.valueOf(this.magicResistance));

        player.setPierceResistance(this.physicalResistance);

        player.setLifePoints(this.lifePoint);

        player.setOtherEnergy(this.otherEnergy);

        player.setMetier(this.metier);

        player.setRace(this.race);

        player.setAttack(this.attack);

        player.setParade(this.parade);

        this.player = player;

        savePlayer(player);

    }

    public void savePlayer(Player player)
    {

        try
        {

            File saveFile = new File(getActivity().getFilesDir(), getActivity().getString(R.string.save_file_name));

            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(player);

            fileOutputStream.close();

            objectOutputStream.close();

            Toast.makeText(getActivity(), "Fiche sauvegardée !", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e)
        {

            System.out.println(e.getMessage());

            Toast.makeText(getActivity(), "Coulnd't save player: "+ e.getMessage(), Toast.LENGTH_LONG).show();

        }

    }

    public Player loadPlayer() {

        try {

            File saveFile = new File(getActivity().getFilesDir(), getActivity().getString(R.string.save_file_name));

            FileInputStream fileInputStream = new FileInputStream(saveFile);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Player player = (Player)objectInputStream.readObject();

            objectInputStream.close();

            fileInputStream.close();

            return player;

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

    public Boolean checkAllFields()
    {

        if(courageText.getText().length() == 0
                || intelText.getText().length() == 0
                || charismeText.getText().length() == 0
                || adressText.getText().length() == 0
                || forceText.getText().length() == 0
                || magicResistanceText.getText().length() == 0
                || physicalResistanceText.getText().length() == 0
                || lifePointText.getText().length() == 0
                || otherEnergyText.getText().length() == 0
                || raceText.getText().length() == 0
                || metierText.getText().length() == 0
                || attackText.getText().length() == 0
                || paradeText.getText().length() == 0)
        {

            return false;
        }

        return true;

    }

}
