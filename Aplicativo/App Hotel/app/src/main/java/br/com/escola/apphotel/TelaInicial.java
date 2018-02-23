package br.com.escola.apphotel;


import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class TelaInicial extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4682B4")));

        //FRAGMENT
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_menu2) {
            fm.beginTransaction().replace(R.id.content_frame, new FiltroFragment()).commit();

        } else if (id == R.id.settings) {
            Intent abreSettings = new Intent(TelaInicial.this,MyPreferencesActivity.class);
            abreSettings.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(abreSettings);

        } else if (id == R.id.atendimento){
            Intent abreAtendimento = new Intent(TelaInicial.this,AtendimentoActivity.class);
            abreAtendimento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(abreAtendimento);

        } else if (id == R.id.termos){
            Intent abreCondicao = new Intent(TelaInicial.this,TermosCondicao.class);
            abreCondicao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(abreCondicao);

        } else if (id == R.id.privacidade) {
            Intent abrePolitica = new Intent(TelaInicial.this,PoliticaPrivacidade.class);
            abrePolitica.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(abrePolitica);

        } else if (id == R.id.usuario) {
            Intent abreUsuario = new Intent(TelaInicial.this,InfoUsuario.class);
            abreUsuario.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            startActivity(abreUsuario);

        } else if (id == R.id.nav_menu) {
            fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
        }

        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawerLayout);
        if(dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);


        return false;
    }
}
