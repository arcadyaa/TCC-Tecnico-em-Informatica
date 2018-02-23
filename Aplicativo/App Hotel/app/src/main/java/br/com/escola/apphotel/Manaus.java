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
import android.widget.Toast;


public class Manaus extends ListFragment{
    String[] players={"Hotel Adrianopolis All Suites","InterCity Premium Manaus","Comfort Hotel Manaus","Go Inn Manaus", "Quality Hotel Manaus"};

    int[] images={R.drawable.adrianopolis,R.drawable.intercity,R.drawable.comfort,R.drawable.goinn,R.drawable.quality};

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
                    Intent intent = new Intent(getActivity(), Adrianopolis.class);
                    startActivity(intent);
                }
                if(pos==1){
                    Intent intent = new Intent(getActivity(), InterCity.class);
                    startActivity(intent);
                }
                if(pos==2){
                    Intent intent = new Intent(getActivity(), ComfortHotel.class);
                    startActivity(intent);
                }
                if(pos==3){
                    Intent intent = new Intent(getActivity(), GoInn.class);
                    startActivity(intent);
                }
                if(pos==4){
                    Intent intent = new Intent(getActivity(), QualityHotel.class);
                    startActivity(intent);
                }
            }
        });
    }
}