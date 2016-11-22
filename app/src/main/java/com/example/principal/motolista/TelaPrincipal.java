package com.example.principal.motolista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import static com.example.principal.motolista.R.id.activity_tela_principal;

public class TelaPrincipal extends AppCompatActivity {

    ListView listview;
    String[] Motokas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        listview = (ListView)findViewById(R.id.MotoSeletor);
        listview.setOnItemClickListener(new ListClickHandler());

        String[] Motokas = {"Honda Biz", "Honda CG", "Yamaha DragStar", "Suzuki Yes", "Harley Davidson"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.MotoSeletor, Motokas);

        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {

            TextView listText = (TextView) view.findViewById(R.id.listText);
            String text = listText.getText().toString();


            Intent intent = new Intent(activity_tela_principal.this, TelaDetalhamento.class);

            intent.putExtra("moto-selecionada", text);
            startActivity(intent);

        }

    }
}