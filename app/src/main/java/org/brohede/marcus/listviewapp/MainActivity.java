package org.brohede.marcus.listviewapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    private String[]mountainCountry ={"Schweiz","Frankrike/Italien","USA"};

    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = new ArrayList<>(Arrays.asList(mountainNames));

        //List<String> listData = new ArrayList<String>(Arrays.asList(mountainNames));

        //ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview,R.id.my_item_textview, listData);

        //ListView myListView = (ListView)findViewById(R.id.my_listview);
        //myListView.setAdapter(adapter);

        //adapter.add("Lukas");

        String[] gustav = new String[]{"Welcome To MountainFacts"};
        Toast.makeText(getApplicationContext(),Arrays.toString(gustav),Toast.LENGTH_SHORT).show();

      //  myListView.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
           //     Toast.makeText(getApplicationContext(),"name:"+mountainNames[i],Toast.LENGTH_SHORT).show();
         //   }
       // });
//Hej
        //kopplar listan med hjälp av en adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item_textview,listData);

        ListView my_listView=(ListView) findViewById(R.id.my_listview);

        my_listView.setAdapter(adapter);
        //Gör så att Toasten kommer fram när man clickar på någon av raderna
        my_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Då tar man contexten och den information som tillhör och visar den datan, i ordningen namn, höjd, plats och land.
                Toast.makeText(getApplicationContext(),"Name:  "+mountainNames[i]+"\n"+"Heigth:  "+mountainHeights[i]+"\n"+"Location:  "+mountainLocations[i]+"\n"+"Country:  "+mountainCountry[i],Toast.LENGTH_SHORT).show();
            }
        });
        // The onCreate method is run when the app is created.
        // Before you can implement this you need to create the layout xml files that
        // will hold/show your data created here. You need three create things:
        // * my_listview - the ID to the actual layout element that is our ListView.
        //                 This my_listview element is created in the activity_main.xml file
        // * list_item_textview - This is a new layout xml file that holds the layout for an
        //                        individual item in the ListView we are creating
        // * my_item_textview - This is the ID to the actual TextView that will contain the text for
        //                      an individual item in the ListView we are creating.
        // Here you should enter your code that fills the ListView
        // 1. Create an array
        // 2. Create a List object with your array from step 1 as in-data
        // 3. Create an ArrayAdapter object that connects
        //    * list_item_textview
        //    * my_item_textview
        //    * List object created in step 2
        // 4. Find the ListView layout element "my_listview" and create an object instance
        // 5. Connect the ArrayAdapter from step 3 with ListView object created in step 4
        // 6. Style the ListView items according to Material Design
        //    See: https://material.io/guidelines/components/lists.html#lists-specs
        //    Look for "singel line specs" for "text only" lists and modify the list_item_textview
        //    accordingly
    }
}
