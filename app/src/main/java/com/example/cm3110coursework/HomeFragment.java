package com.example.cm3110coursework;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // for navigate to the forecast fragment
        ImageButton btnRecipe = view.findViewById(R.id.recipeBtn);
        btnRecipe.setOnClickListener(this);

        ImageButton btnIngredient = view.findViewById(R.id.ingredientBtn);
        btnIngredient.setOnClickListener(this);

        ImageButton btnMealPlan = view.findViewById(R.id.mealplanBtn);
        btnMealPlan.setOnClickListener(this);

        ImageButton btnProduct = view.findViewById(R.id.productBtn);
        btnProduct.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.recipeBtn){
            Navigation.findNavController(v).navigate(R.id.recepiesFragment);
        }
        if (v.getId() == R.id.ingredientBtn){
            Navigation.findNavController(v).navigate(R.id.ingredientsFragment);
        }
        if (v.getId() == R.id.mealplanBtn){
            Navigation.findNavController(v).navigate(R.id.mealPanningFragment);
        }
        if (v.getId() == R.id.productBtn){
            Navigation.findNavController(v).navigate(R.id.productsFragment);
        }
    }
}