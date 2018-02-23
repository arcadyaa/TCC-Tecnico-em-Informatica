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


public class SaoPaulo extends ListFragment{
    String[] players={"Maksoud Plaza Hotel", "Astron Garden Special", "WZ Jardins", "WZ Century Paulista", "London Class Suites"};
    int[] images={R.drawable.maksoud,R.drawable.gar2,R.drawable.jardim,R.drawable.cen, R.drawable.london};

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
                    Intent intent = new Intent(getActivity(), Marksoud.class);
                    startActivity(intent);
                }
                if(pos==1){
                    Intent intent = new Intent(getActivity(), AstronGarden.class);
                    startActivity(intent);
                }
                if(pos==2){
                    Intent intent = new Intent(getActivity(), WzJardins.class);
                    startActivity(intent);
                }
                if(pos==3){
                    Intent intent = new Intent(getActivity(), WzCentury.class);
                    startActivity(intent);
                }
                if(pos==4){
                    Intent intent = new Intent(getActivity(), LondonClass.class);
                    startActivity(intent);
                }
            }
        });
    }
}