package com.example.agterra.jdrnaheulbeuk;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Agterra on 11/07/2017.
 */

public class AbilitiesFragment extends Fragment {

    private ListView listView;

    public ArrayAdapter<String> adaptedObjects;

    public ArrayList<String> objects;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.abilities, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        final ArrayList<String> objects = new ArrayList<>();

        this.objects = objects;

        final ArrayAdapter<String> adaptedOjects = new ArrayAdapter<String>(getActivity(), R.layout.fragment_abilityitem, R.id.object_text, objects);

        this.adaptedObjects = adaptedOjects;

        ListView listView = (ListView)getView().findViewById(R.id.abilitiesListView);

        listView.setAdapter(adaptedOjects);

        this.listView = listView;

        final Button addObjectButton = (Button)getView().findViewById(R.id.addObject);

        addObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addObject(" ");

            }
        });

        final Button removeObjectButton = (Button)getView().findViewById(R.id.removeObject);

        removeObjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeLastObject();

            }
        });

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final int position = i;

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                builder.setTitle("Nom de l'object");

                final EditText input = new EditText(getActivity());

                input.setInputType(InputType.TYPE_CLASS_TEXT);

                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        objects.set(position, input.getText().toString());

                    }
                });

                builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });

                builder.show();

                System.out.println(objects);

                adaptedOjects.notifyDataSetChanged();

            }
        });

    }

    public void savePlayer(Player player)
    {

        try
        {

            File saveFile = new File(getActivity().getFilesDir(), getActivity().getString(R.string.save_file_name));

            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(player);

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

    public void addObject(String object)
    {

        this.objects.add(object);

        this.adaptedObjects.notifyDataSetChanged();

    }

    public void removeLastObject()
    {

        if(this.objects.size()>0) {

            this.objects.remove(this.objects.size() - 1);

            this.adaptedObjects.notifyDataSetChanged();

        }

    }

}
