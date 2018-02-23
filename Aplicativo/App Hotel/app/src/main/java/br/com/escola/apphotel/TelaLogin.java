package br.com.escola.apphotel;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class TelaLogin extends AppCompatActivity {

    EditText editEmail, editSenha;
    ImageButton btnLogar;
    TextView txtCadastro;

    String url = "";
    String parametro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);


        editEmail    = (EditText)     findViewById(R.id.editEmail);
        editSenha    = (EditText)     findViewById(R.id.editSenha);
        btnLogar     = (ImageButton)  findViewById(R.id.btnLogar);
        txtCadastro  = (TextView)     findViewById(R.id.txtCadastro);


    txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abreCadastro = new Intent(TelaLogin.this,TelaCadastro.class);
                startActivity(abreCadastro);
            }
        });

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String email = editEmail.getText().toString();
                    String senha = editSenha.getText().toString();

                    if(email.isEmpty() || senha.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                    } else {

                        url = "https://plazahoteis.000webhostapp.com/logar.php";

                        parametro = "email=" + email + "&senha=" + senha;

                        new SolicitaDados().execute(url);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhuma Conexão foi detectada!", Toast.LENGTH_LONG).show();
                }
            }
        }
    );
    }


    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametro);
        }

        protected void onPostExecute(String resultado) {


            if(resultado.contains("login_ok")) {

                String[] dados = resultado.split(",");

                Intent abreInicio = new Intent(TelaLogin.this,TelaInicial.class);
                abreInicio.putExtra("nome_usuario", dados[1]);
                startActivity(abreInicio);

            } else {
                Toast.makeText(getApplicationContext(), "Usuario ou senha estão incorretos!", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
