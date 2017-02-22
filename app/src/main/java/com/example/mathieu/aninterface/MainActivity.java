package com.example.mathieu.aninterface;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listHome;
    ArrayList<HomeRow> homeRows;
    ViewFlipper activity_main;

    TextView layoutOptionsText;
    TextView languageOptionsText;
    TextView defaultModeOptionsText;


    RadioButton leftOption;
    RadioButton rightOption;
    RadioButton frenchOption;
    RadioButton englishOption;
    RadioButton homeOption;
    RadioButton photoOption;
    RadioButton writeOption;

    int ScreenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting all widget
        activity_main = (ViewFlipper) findViewById(R.id.activity_main);
        listHome  = (ListView) findViewById(R.id.listHome);


        //TextView
        layoutOptionsText = (TextView) findViewById(R.id.layoutOptionsText);
        languageOptionsText = (TextView) findViewById(R.id.languageOptionsText);
        defaultModeOptionsText = (TextView) findViewById(R.id.defaultModeOptionsText);

        //RadioButton
        leftOption = (RadioButton) findViewById(R.id.leftOption);
        rightOption = (RadioButton) findViewById(R.id.rightOption);
        frenchOption = (RadioButton) findViewById(R.id.frenchOption);
        englishOption = (RadioButton) findViewById(R.id.englishOption);
        homeOption = (RadioButton) findViewById(R.id.homeOption);
        photoOption = (RadioButton) findViewById(R.id.photoOption);
        writeOption = (RadioButton) findViewById(R.id.writeOption);

        homeRows = new ArrayList<>();

        //Getting the screen dimensions
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ScreenWidth = size.x;
        screenHeight = size.y;

        //adding home element
        homeRows.add(new HomeRow(R.drawable.camera, getResources().getString(R.string.photo)));
        homeRows.add(new HomeRow(R.drawable.pen, getResources().getString(R.string.Ecrire)));
        homeRows.add(new HomeRow(R.drawable.keyboard, getResources().getString(R.string.clavier)));
        homeRows.add(new HomeRow(R.drawable.wrench, getResources().getString(R.string.parametres)));

        AdapterHome adapterHome = new AdapterHome(MainActivity.this, R.layout.menu_elements_layout, homeRows);

        listHome.setAdapter(adapterHome);



        //handling click events for the home page items
        listHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection
                switch (position) {
                    case 0:         //Photo element selected
                        openPhoto();
                        break;
                    case 1:         //Writing element selected
                        openWriting();
                        break;
                    case 2:         //Keyboard element selected
                        openKeyboard();
                        break;
                    case 3:         //Parameter element selected
                        openParameter();
                        break;
                }
            }
        });

        adjustTextToScreen(screenHeight);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    /**
     * handling click events for the main menu items
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mItemParamètres:
                openParameter();
                return true;
            case R.id.mItemHome:
                openHome();
                return true;
            case R.id.mItemPhoto:
                openPhoto();
                return true;
            case R.id.mItemEcrire:
                openWriting();
                return true;
            case R.id.mItemClavier:
                openKeyboard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Open the photo mode page
     */
    void openPhoto(){
        Toast.makeText(this, "photo", Toast.LENGTH_SHORT).show();
        //activity_main.setDisplayedChild();
    }

    /**
     * Open Writing page
     */
    void openWriting(){
        Toast.makeText(this, "writing", Toast.LENGTH_SHORT).show();
        //activity_main.setDisplayedChild();
    }

    /**
     * Open Keyboard page
     */
    void openKeyboard(){
        Toast.makeText(this, "keyboard", Toast.LENGTH_SHORT).show();
        //activity_main.setDisplayedChild();
    }

    /**
     * open parameter page
     */
    void openParameter(){
        activity_main.setDisplayedChild(1); //the parameter page is 1
    }

    /**
     * open home page
     */
    void openHome() {
        activity_main.setDisplayedChild(0); //the home page is 0
    }


    /**
     * Adjust the text size depending on the screen size
     * @param height the height of the screen
     */
    void adjustTextToScreen(int height){

        int textViewSize = height/45;
        int radioBtnTxtSize = height/65;
        layoutOptionsText.setTextSize(textViewSize);
        languageOptionsText.setTextSize(textViewSize);
        defaultModeOptionsText.setTextSize(textViewSize);

        leftOption.setTextSize(radioBtnTxtSize);
        rightOption.setTextSize(radioBtnTxtSize);
        frenchOption.setTextSize(radioBtnTxtSize);
        englishOption.setTextSize(radioBtnTxtSize);
        homeOption.setTextSize(radioBtnTxtSize);
        photoOption.setTextSize(radioBtnTxtSize);
        writeOption.setTextSize(radioBtnTxtSize);
    }


}
