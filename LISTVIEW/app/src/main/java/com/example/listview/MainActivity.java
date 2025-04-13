package com.example.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] presidents = {
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johnson",
            "Richard Nixon",
            "Gerald Ford",
            "Jimmy Carter",
            "Ronald Reagan",
            "George H. W. Bush",
            "Bill Clinton",
            "George W. Bush",
            "Barack Obama"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Obtener la vista de lista
        ListView listView = getListView();
        // Configurar el modo de selección múltiple
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // Habilitar filtro de texto para la lista
        listView.setTextFilterEnabled(true);
        // Establecer el adaptador con los datos
        setListAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_checked,
                presidents
        ));
    }

    @Override
    public void onListItemClick(ListView parent, View v, int position, long id) {
        // Mostrar un Toast con el presidente seleccionado
        Toast.makeText(
                this,
                "has seleccionado: " + presidents[position],
                Toast.LENGTH_SHORT
        ).show();
    }
}