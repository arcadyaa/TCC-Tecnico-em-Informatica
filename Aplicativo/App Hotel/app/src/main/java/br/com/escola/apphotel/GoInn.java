package br.com.escola.apphotel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoInn extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Intent callIntent;
    Button mCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_inn);
        init();

        //Cor PLAZA
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4682B4")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Botão E-mail
        Button btnEmail = (Button) findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"reservas.gmao@atlanticahotels.com.br"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto:");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Mensagem");

                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Escolha qual aplicativo utilizar: "));

            }
        });
    }

    // Botão Site!!
    public void browser1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.atlanticahotels.com.br/hotel/manaus/go-inn-manaus"));
        startActivity(browserIntent);
    }


    //Botão Telefone
    private void init() {
        mCallButton = (Button) findViewById(R.id.call);
        mCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent = new Intent (Intent.ACTION_CALL,Uri.parse("tel: 9233062600"));
                if (ContextCompat.checkSelfPermission(GoInn.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(GoInn.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

                }else {
                    startActivity(callIntent);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL: {
                if (grantResults.length > 0  && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    startActivity(callIntent);
                } else {
                    ////
                }
            }
        }
    }
}
