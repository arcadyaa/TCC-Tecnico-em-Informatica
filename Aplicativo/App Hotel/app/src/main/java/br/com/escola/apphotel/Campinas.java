package br.com.escola.apphotel;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;



public class Campinas extends ListFragment {

    String[] players={"Dan Inn Cambui","Astron Associado Park Tower","Noumi Plaza Hotel","Hotel Vila Rica", "Leon Park Hotel"};

    int[] images={R.drawable.daninn,R.drawable.astron1,R.drawable.noumi,R.drawable.vila,R.drawable.leon};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //MAP
        HashMap<String, String> map=new HashMap<String, String>();
        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"Player","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
                // TODO Auto-generated method stub

                if(pos==0){
                    Intent intent = new Intent(getActivity(), DanInn.class);
                    startActivity(intent);
                }
                if(pos==1){
                    Intent intent = new Intent(getActivity(), AstronPark.class);
                    startActivity(intent);
                }
                if(pos==2){
                    Intent intent = new Intent(getActivity(), NoumiHotel.class);
                    startActivity(intent);
                }
                if(pos==3){
                    Intent intent = new Intent(getActivity(), VilaRica.class);
                    startActivity(intent);
                }
                if(pos==4){
                    Intent intent = new Intent(getActivity(), LeonPark.class);
                    startActivity(intent);
                }

            }
        });
    }
}