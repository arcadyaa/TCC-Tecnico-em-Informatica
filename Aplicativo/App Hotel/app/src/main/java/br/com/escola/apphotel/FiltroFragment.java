package br.com.escola.apphotel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import static br.com.escola.apphotel.R.id.tabHost;


public class FiltroFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInatanceState) {

        View rootView = inflater.inflate(R.layout.fragment_filtro, container, false);

        //TAB HOST
        TabHost host = (TabHost)rootView.findViewById(tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Campinas");
        spec.setContent(R.id.campinas);
        spec.setIndicator("Campinas");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("São Paulo");
        spec.setContent(R.id.saopaulo);
        spec.setIndicator("São Paulo");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Manaus");
        spec.setContent(R.id.manaus);
        spec.setIndicator("Manaus");
        host.addTab(spec);

        return rootView;

    }

}
