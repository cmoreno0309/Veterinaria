package com.veterinaria.proyecto.veterinaria;

//import android.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main_Fragment_Mascota extends AppCompatActivity {
    private ViewPager _mViewPager;
    private ImageViewPagerAdapterMascota _adapter;
    private ImageView _btn1, _btn2;
    public static final String ID_MASCOTA = "ID_MASCOTA";
    public static final String NOMBRE = "NOMBRE";
    public static final String EDAD = "EDAD";
    public static final String CUMPLEANOS = "CUMPLEANOS";
    public static final String SEXO = "SEXO";
    public static final String RAZA = "RAZA";
    public static final String PESO = "PESO";
    public static final String ALIMENTACION = "ALIMENTACION";
    public static final String TRATAMIENTO = "TRATAMIENTO";
    public static final String COLOR = "COLOR";
    public static final String ESTERILIZADO = "ESTERILIZADO";
    public static final String ENCONTRADO = "ENCONTRADO";



    public Main_Fragment_Mascota() {
    }
    FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpView();
        setTab();
        onCircleButtonClick();


        /*ViewPager vpPager = (ViewPager) findViewById(R.id.imageviewPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);*/

        Bundle parametros = this.getIntent().getExtras();
        Boolean encontrado = parametros.getBoolean(ENCONTRADO);

        if(encontrado) {
            //idmascota = parametros.getInt(ID_MASCOTA);
            String nombre = parametros.getString(NOMBRE);
            String edad = parametros.getString(EDAD);
            String cumpleanos = parametros.getString(CUMPLEANOS);
            String sexo = parametros.getString(SEXO);
            String raza = parametros.getString(RAZA);
            String peso = parametros.getString(PESO);
            String alimentacion = parametros.getString(ALIMENTACION);
            String tratamiento = parametros.getString(TRATAMIENTO);
            String color = parametros.getString(COLOR);
            String esterilizado = parametros.getString(ESTERILIZADO);
        }
    }



    private void onCircleButtonClick() {

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn1.setImageResource(R.drawable.fill_circle);
                _mViewPager.setCurrentItem(0);
            }
        });

        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btn2.setImageResource(R.drawable.fill_circle);
                _mViewPager.setCurrentItem(1);
            }
        });
    }
    private void setUpView() {
        //_mViewPager = (ViewPager) getView().findViewById(R.id.imageviewPager);
        _mViewPager = (ViewPager) findViewById(R.id.imageviewPager);
        //_adapter = new ImageViewPagerAdapterMascota(getActivity(), getFragmentManager());
        _adapter = new ImageViewPagerAdapterMascota(getSupportFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
        initButton();
    }
    private void setTab() {
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int position) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                _btn1.setImageResource(R.drawable.holo_circle);
                _btn2.setImageResource(R.drawable.holo_circle);
                btnAction(position);
            }

        });

    }
    private void btnAction(int action) {
        switch (action) {
            case 0:
                _btn1.setImageResource(R.drawable.fill_circle);

                break;

            case 1:
                _btn2.setImageResource(R.drawable.fill_circle);

                break;
        }
    }

    private void initButton() {
        _btn1 = (ImageView) findViewById(R.id.btn1);
        _btn1.setImageResource(R.drawable.fill_circle);
        _btn2 = (ImageView) findViewById(R.id.btn2);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                break;

        }
        return true;
    }
    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpView();
        setTab();
        onCircleButtonClick();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_mascota, container, false);
    }



    private void setButton(Button btn, String text, int h, int w) {
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setText(text);
    }*/
}
