package br.com.escola.apphotel;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText editNome, editEmail2, editSenha2;
    Button btnCancelar, btnRegistrar;

    String url = "";
    String parametro = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        editNome     = (EditText)findViewById(R.id.editNome);
        editEmail2   = (EditText)findViewById(R.id.editEmail2);
        editSenha2   = (EditText)findViewById(R.id.editSenha2);
        btnRegistrar = (Button)  findViewById(R.id.btnRegistrar);
        btnCancelar  = (Button)  findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(it);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String nome = editNome.getText().toString();
                    String email = editEmail2.getText().toString();
                    String senha = editSenha2.getText().toString();

                    if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                    } else {

                        url = "https://plazahoteis.000webhostapp.com/registrar.php";

                        parametro = "nome=" + nome + "&email=" + email + "&senha=" + senha;

                        new SolicitaDados().execute(url);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhuma Conexão foi detectada!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametro);
        }

        @Override
        protected void onPostExecute(String resultado) {

            if(resultado.contains("email_erro")) {

                Toast.makeText(getApplicationContext(), "Este email já está cadastrado!", Toast.LENGTH_LONG).show();

            } else if(resultado.contains("registro_ok")) {
                Toast.makeText(getApplicationContext(), "Registro concluido com sucesso!", Toast.LENGTH_LONG).show();
                Intent abreInicio = new Intent(TelaCadastro.this,TelaLogin.class);
                startActivity(abreInicio);
            } else {
                Toast.makeText(getApplicationContext(), "Ocorreu algum erro!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
