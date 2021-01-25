package activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onsoundplay.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterActivity;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.io.File;
import java.util.ArrayList;


public class Track extends AppCompatActivity {

    private ArrayList<Music> arraylist;
    private MusicAdapter adapter;
    private ListView songList;
    private View view1;
    private View view2;

    //@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);


        //Erro
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //toolbar.setTitle("OnSoundPlay");




        songList = (ListView) findViewById(R.id.songList);
        arraylist = new ArrayList<>();
        arraylist.add(new Music("Big Jet Plane", "Alok", R.raw.big_jet_plane));
        arraylist.add(new Music("Byob", "Alok", R.raw.byob));
        arraylist.add(new Music("Hear Me Now", "Alok", R.raw.hear_me_now));
        arraylist.add(new Music("I Dont't Wanna Talk", "Alok", R.raw.i_dont_wanna_talk));
        arraylist.add(new Music("Never Let Me Go", "Alok", R.raw.never_let_me_go));
        arraylist.add(new Music("Play Hard", "David Guetta", R.raw.play_hard));
        arraylist.add(new Music("So Far Away", "David Guetta", R.raw.so_far_away));
        arraylist.add(new Music("Titanium", "David Guetta", R.raw.titanium));

        adapter = new MusicAdapter(this, R.layout.item_structure, arraylist);
        songList.setAdapter( adapter );
    }
    @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.optionsmenu, menu);
            return super.onCreateOptionsMenu(menu);
        }


        public boolean onOptionsItemselected(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.avaliar:
                    abrirSpinner();
                    break;
                case R.id.sobre:
                    abrirMensagem(view1);
                    break;
                case R.id.sair:
                    sairdoAplicativo(view2);
                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        private void abrirSpinner() {

        }

        private void abrirMensagem(View view1) {
            Toast.makeText(getApplicationContext(), "" + "Este aplicativo consiste em executar algumas músicas " +
                    " eletrônicas disponíveis na base de dados do deste sistema", Toast.LENGTH_LONG).show();
    }

        private void sairdoAplicativo(View view2) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Sair");
            dialog.setMessage("Deseja realmente sair?");

            dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });

            dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });


        }
}