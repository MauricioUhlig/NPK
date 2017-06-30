package br.com.softweb.npk.activity.submenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import java.util.ArrayList;
import java.util.List;
import br.com.softweb.npk.R;
import br.com.softweb.npk.activity.submenu.fragaduba.FragmentAZ;
import br.com.softweb.npk.activity.submenu.fragaduba.FragmentGrupo;
import br.com.softweb.npk.activity.submenu.fragaduba.culturas.*;


public class RecoAduba extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reco_aduba);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAZ(), "A-Z");
        adapter.addFragment(new FragmentGrupo(), "GRUPO");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    public void recAbacate(View v){
        Intent it = new Intent(this, Abacate.class);
        startActivity(it);
    }
    public void recAbacaxi(View v){
        Intent it = new Intent(this, Abacaxi.class);
        startActivity(it);
    }
    public void recAbobRasteira(View v){
        Intent it = new Intent(this, AboboraRasterira.class);
        startActivity(it);
    }
    public void recAbobMoita(View v){
        Intent it = new Intent(this, AboboraMoita.class);
        startActivity(it);
    }
    public void recAcerola(View v){
        Intent it = new Intent(this, Acerola.class);
        startActivity(it);
    }
    public void recAlfaceAgriao(View v){
        Intent it = new Intent(this, AlfaceAgriao.class);
        startActivity(it);
    }
    public void recAlho(View v){
        Intent it = new Intent(this, Alho.class);
        startActivity(it);
    }
    public void recAmeixa(View v){
        Intent it = new Intent(this, Ameixa.class);
        startActivity(it);
    }
    public void recAlgodao (View v){
        Intent it = new Intent(this, Algodao.class);
        startActivity(it);
    }
    public void recArrozInundado (View v){
        Intent it = new Intent(this, ArrozInundado.class);
        startActivity(it);
    }
    public void recArrozSequeiro (View v){
        Intent it = new Intent(this, ArrozSequeiro.class);
        startActivity(it);
    }
    public void recBanana (View v){
        Intent it = new Intent(this, Banana.class);
        startActivity(it);
    }
    public void recBatata (View v){
        Intent it = new Intent(this, Batata.class);
        startActivity(it);
    }
    public void recBatataDoce (View v){
        Intent it = new Intent(this, BatataDoce.class);
        startActivity(it);
    }

    public void recBerinjela (View v){
        Intent it = new Intent(this, Berinjela.class);
        startActivity(it);
    }
    public void recBeterraba (View v){
        Intent it = new Intent(this, Beterraba.class);
        startActivity(it);
    }
    public void recBrocolos (View v){
        Intent it = new Intent(this, Brocolos.class);
        startActivity(it);
    }
    public void recBucha (View v){
        Intent it = new Intent(this, Bucha.class);
        startActivity(it);
    }
}
