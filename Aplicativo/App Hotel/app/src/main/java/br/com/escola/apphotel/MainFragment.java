package br.com.escola.apphotel;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class MainFragment extends Fragment implements View.OnClickListener{

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInatanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //BOTÃO!!
        ImageButton hotelBtn = (ImageButton) rootView.findViewById(R.id.btnHotel);
        hotelBtn.setOnClickListener(this);

        return rootView;

    }
    //BOTÃO!!
    @Override
    public void onClick(View view) {

        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.btnHotel:
                fragment = new FiltroFragment();
                replaceFragment(fragment);
                break;

        }
    }
    //BOTÃO!!
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}