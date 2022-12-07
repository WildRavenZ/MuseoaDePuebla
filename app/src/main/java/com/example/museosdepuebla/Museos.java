package com.example.museosdepuebla;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Museos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] c = getResources().getStringArray(R.array.museoslist);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_museos,c));

        ListView view = getListView();
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                if (id == 0) {
                    Uri uri = Uri.parse("geo:19.0918046,-98.2341392");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 1) {
                    Uri uri = Uri.parse("geo:19.0416757,-98.1991955");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 2) {
                    Uri uri = Uri.parse("geo:19.0577691,-98.1837606");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 3) {
                    Uri uri = Uri.parse("geo:19.0941801,-98.2368737");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 4) {
                    Uri uri = Uri.parse("geo:19.0938331,-98.2366378");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 5) {
                    Uri uri = Uri.parse("geo:19.0417815,-98.1984116");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 6) {
                    Uri uri = Uri.parse("geo:19.0446219,-98.2028336");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 7) {
                    Uri uri = Uri.parse("geo:19.0441273,-98.1949906");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 8) {
                    Uri uri = Uri.parse("geo:19.0188014,-98.2484779");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 9) {
                    Uri uri = Uri.parse("geo:19.0399323,-98.2057946");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 10) {
                    Uri uri = Uri.parse("geo:19.0589208,-98.3025643");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 11) {
                    Uri uri = Uri.parse("geo:19.0459608,-98.1973868");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 12) {
                    Uri uri = Uri.parse("geo:19.050184,-98.1997119");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 13) {
                    Uri uri = Uri.parse("geo:19.0438441,-98.1954756");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 14) {
                    Uri uri = Uri.parse("geo:19.0548205,-98.2046826");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 15) {
                    Uri uri = Uri.parse("geo:19.0442108,-98.1974173");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 16) {
                    Uri uri = Uri.parse("geo:19.4116573,-99.1969259");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 17) {
                    Uri uri = Uri.parse("geo:19.0409316,-98.200634");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 18) {
                    Uri uri = Uri.parse("geo:19.0525465,-98.182066");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
                if (id == 19) {
                    Uri uri = Uri.parse("geo:19.0570455,-98.1837997");
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            }
        });
    }
}