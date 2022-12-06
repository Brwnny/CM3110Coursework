package com.example.cm3110coursework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecepiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipesFragment newInstance(String param1, String param2) {
        RecipesFragment fragment = new RecipesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // for navigate to the forecast fragment
        ImageButton btnBack = view.findViewById(R.id.backBtn);
        btnBack.setOnClickListener(this);

            getRecipe();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backBtn){
            Navigation.findNavController(v).navigate(R.id.homeFragment);
        }
    }

    public void getRecipe() {

       String url = "https://www.themealdb.com/api/json/v1/1/categories.php";

       StringRequest request= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
                List<Recipe> recipe = new ArrayList<Recipe>();
                Log.d("hey" , "hi");

                try {
                    JSONObject object = new JSONObject(response);
                    Log.e("hi"  , " hey" + object);
                  //  Log.e("objectss", "object" );
                  //  JSONArray recipeArray = object.getJSONArray("categories ");
                  //  Log.e("objectss", "object"  + recipeArray);

                    JSONArray testObject = object.getJSONArray("categories");
                    Log.e("objectssdasdasdas", "object" + testObject );



                    for (int i = 0; i < testObject.length(); i++) {
                        JSONObject category = testObject.getJSONObject(i);
                        String categories = category.getString("strCategory");

                        int id = category.getInt("idCategory");

                        String description = category.getString("strCategoryDescription");

                        Recipe recipe1 = new Recipe();
                        recipe1.setDescription(description);
                        recipe1.setIdCategory(id);
                        recipe1.setStrCategory(categories);
                        recipe.add(recipe1);

                    }

                }

                catch (JSONException e) {
                    e.printStackTrace();
               }

                finally {
                    Log.e("HEY THIS WORKED", "hey it worked!!! we downloaded" + recipe.size());


                    if(recipe.size() > 0) {
                        ListView listView = getActivity().findViewById(R.id.listView);
                        listView.setVisibility(View.VISIBLE);

                        ArrayAdapter<Recipe> recipeAdapter = new ArrayAdapter<Recipe>(getContext() , android.R.layout.simple_list_item_1, recipe );
                        listView.setAdapter(recipeAdapter);
                    }
                }


           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });
        RequestQueue rq = Volley.newRequestQueue(getContext());
        rq.add(request);

    }

}

